package com.foodexpress.menuservice.domain;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public record File(
    String fileId,
    String filePath,
    String fileName,
    String originalFileName,
    String contentType,
    String extension
) {

}
