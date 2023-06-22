
package com.TiendaSC_403.service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public interface FirebaseStorageService {
    
    //Esto es un método para
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);//id:cuando guardemos va a evitar que se repita

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "techshop-28956.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "techshop";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "techshop-28956-firebase-adminsdk-f2f96-72bb1b40d1.json";//tiene que termianr en .json, se saca del link de firebase

}
