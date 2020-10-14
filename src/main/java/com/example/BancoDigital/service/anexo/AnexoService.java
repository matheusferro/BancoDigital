package com.example.BancoDigital.service.anexo;

import com.example.BancoDigital.model.Anexo;
import com.example.BancoDigital.repository.anexo.AnexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class AnexoService {

    @Autowired
    AnexoRepository repository;

    @Value("${app.upload.dir=A:/testeSpring/}")
    private String arqDir;

    public void uploadArquivo(String _idCliente, MultipartFile _arquivo){
        try{
            if(!_arquivo.getContentType().equals("image/jpeg") ){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro. Envie uma imagem no formato .JPEG ou .JPG");
            }
            String caminhoCompleto = arqDir + File.separator + StringUtils.cleanPath(_arquivo.getOriginalFilename());
            Long tbClienteId = Long.parseLong(_idCliente);
            Anexo anexo = new Anexo();
            anexo.setClienteId(tbClienteId);
            anexo.setCaminho(caminhoCompleto);

            repository.save(anexo);
            Path copiaLocal = Paths.get(caminhoCompleto);
            Files.copy(_arquivo.getInputStream(), copiaLocal, StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception error){
            error.printStackTrace();
        }
    }
}
