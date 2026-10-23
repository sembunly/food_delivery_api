package com.bunli.service.handler;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.bunli.constant.Constant;
import com.bunli.dto.MenuItemPhotoRequest;
import com.bunli.dto.MenuItemPhotoResponse;
import com.bunli.model.MenuItem;
import com.bunli.model.MenuItemPhoto;
import com.bunli.repository.MenuItemPhotoRepository;
import com.bunli.utils.StringClazzUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MenuItemPhotoHandlerService {

    private final MenuItemPhotoRepository menuItemPhotoRepository;
    private final List<String> FILE_EXTENSIONS = Arrays.asList("jpg", "jpeg", "png");

    public MenuItemPhotoHandlerService(MenuItemPhotoRepository menuItemPhotoRepository) {
        this.menuItemPhotoRepository = menuItemPhotoRepository;
    }

    public void validateFileUpload(MultipartFile[] files) {
        if (files.length == 0) {
            log.warn("File is empty");
            throw new IllegalArgumentException("File is empty");
        }
    }

    public void validateValidFileUpload(MultipartFile[] files) {
        for (MultipartFile file : files) {
            var fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            var extension = StringClazzUtils.getFileExtension(fileName);
            if (!FILE_EXTENSIONS.contains(extension)) {
                log.warn("File extension not allow to upload, please verify. File name: {}", fileName);
                throw new IllegalArgumentException("File extension not allow to upload, please verify");
            }
        }
    }

    public void updateFileByMenuItemAndFileId(MenuItem menuItem, List<MenuItemPhotoRequest> menuItemPhotoRequests) {
        final Set<Long> menuItemPhotoIds = menuItemPhotoRequests.stream()
                .map(MenuItemPhotoRequest::getId)
                .collect(Collectors.toSet());

        List<MenuItemPhoto> menuItemPhotos = menuItemPhotoRepository.findAllByIdIn(menuItemPhotoIds);
        for (MenuItemPhoto menuItemPhoto : menuItemPhotos) {
            menuItemPhoto.setMenuItem(menuItem);

            menuItemPhotoRepository.saveAndFlush(menuItemPhoto);
        }
    }

    public MenuItemPhoto convertMenuItemPhotoRequestToMenuItemPhoto(MenuItemPhotoRequest menuItemPhotoRequest,
            MenuItemPhoto menuItemPhoto) {
        menuItemPhoto.setFileName(menuItemPhotoRequest.getFileName());
        menuItemPhoto.setFileType(menuItemPhotoRequest.getFileType());
        menuItemPhoto.setFileFormat(menuItemPhotoRequest.getFileFormat());
        menuItemPhoto.setFileSize(menuItemPhotoRequest.getFileSize());
        menuItemPhoto.setSmallUrl(menuItemPhotoRequest.getSmallUrl());
        menuItemPhoto.setMediumUrl(menuItemPhotoRequest.getMediumUrl());
        menuItemPhoto.setLargeUrl(menuItemPhotoRequest.getLargeUrl());
        menuItemPhoto.setUploadedBy(menuItemPhotoRequest.getUploadedBy());

        menuItemPhoto.setStatus(Constant.ACTIVE);
        if (StringUtils.hasText(menuItemPhotoRequest.getStatus())) {
            menuItemPhoto.setStatus(menuItemPhotoRequest.getStatus());
        }

        if (menuItemPhoto.getId() == null) {
            menuItemPhoto.setCreatedAt(new Date());
            menuItemPhoto.setUpdatedBy(Constant.SYSTEM);
        }
        return menuItemPhoto;
    }

    public MenuItemPhotoResponse convertMenuItemPhotoToMenuItemPhotoResponse(MenuItemPhoto menuItemPhoto) {
        return MenuItemPhotoResponse.builder()
                .id(menuItemPhoto.getId())
                .fileName(menuItemPhoto.getFileName())
                .fileType(menuItemPhoto.getFileType())
                .fileFormat(menuItemPhoto.getFileFormat())
                .fileSize(menuItemPhoto.getFileSize())
                .smallUrl(menuItemPhoto.getSmallUrl())
                .mediumUrl(menuItemPhoto.getMediumUrl())
                .largeUrl(menuItemPhoto.getLargeUrl())
                .uploadedBy(menuItemPhoto.getUploadedBy())
                .status(menuItemPhoto.getStatus())
                .build();
    }

}
