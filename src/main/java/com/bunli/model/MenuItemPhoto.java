package com.bunli.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_menu_item_photo")
public class MenuItemPhoto extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileType;
    private String fileFormat;
    private double fileSize;
    private String fileName;
    private String smallUrl;
    private String mediumUrl;
    private String largeUrl;
    private String uploadedBy;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    private MenuItem menuItem;
}
