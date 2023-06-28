package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Justificatif;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IJustificatifService {
    public  ResponseEntity<?>UploadJust(MultipartFile pdfFile, String libelle) throws IOException ;
    public  ResponseEntity<byte[]>DownloadJustificatif(int id_just);


}
