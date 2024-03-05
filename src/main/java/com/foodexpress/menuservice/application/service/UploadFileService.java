package com.foodexpress.menuservice.application.service;

import com.foodexpress.menuservice.application.port.in.file.UploadFileCommand;
import com.foodexpress.menuservice.application.port.in.file.UploadFileUseCase;
import com.foodexpress.menuservice.application.port.out.UploadMenuImagePort;
import com.foodexpress.menuservice.common.UseCase;
import com.foodexpress.menuservice.domain.File;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class UploadFileService implements UploadFileUseCase {

    private final UploadMenuImagePort uploadMenuImagePort;

    @Override
    public List<File> uploadFile(UploadFileCommand command) {
        return uploadMenuImagePort.uploadMenuImage(command.getUploadFiles(), command.getMenuId());
    }

}
