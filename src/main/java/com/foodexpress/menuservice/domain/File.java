package com.foodexpress.menuservice.domain;

import lombok.Builder;

@Builder
public record File(
    String fileId,
    String filePath,
    String fileName,
    String originalFileName,
    String contentType,
    String extension
) {

}
