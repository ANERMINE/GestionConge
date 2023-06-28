package com.gesconge.gesconge.Services;

import com.gesconge.gesconge.Entities.Justificatif;
import com.gesconge.gesconge.Repositories.IJustificatif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;


import java.io.IOException;

@Service
public class JustificatifService implements IJustificatifService{
    @Autowired
    IJustificatif justificatifRepository;
    @Override
    public ResponseEntity<?>UploadJust(MultipartFile pdfFile, String libelle) throws IOException {
        Justificatif justificatif = new Justificatif();
        justificatif.setLibelle(libelle);
        justificatif.setPdf(pdfFile.getBytes());

        justificatifRepository.save(justificatif);

        return ResponseEntity.ok().build();
    }

    @Override
    public  ResponseEntity<byte[]> DownloadJustificatif(int id_just) {
        Justificatif justificatif = justificatifRepository.findById(id_just)
                .orElseThrow(() -> new NotFoundException("Justificatif introuvable"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.attachment()
                .filename(justificatif.getLibelle() + ".pdf")
                .build());

        return new ResponseEntity<>(justificatif.getPdf(), headers, HttpStatus.OK);
    }
}
