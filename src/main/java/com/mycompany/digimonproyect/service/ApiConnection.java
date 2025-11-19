/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digimonproyect.service;


import com.google.gson.Gson;
import com.mycompany.digimonproyect.model.digimon.Digimon;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam2_alu19@inf.ald
 */
public class ApiConnection {

    private static final String DIGIMON_API = "https://digi-api.com/api/v1/digimon";

    public static void askApi(String nameDigimon) {
        
        try {
            URL urlJson = new URL(DIGIMON_API);
            HttpURLConnection connection = (HttpURLConnection) urlJson.openConnection();
            connection.setRequestMethod("GET");

            // Conecta con el servidor
            int responseCode = connection.getResponseCode();

            // Verifica si la conexión fue exitosa
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("✅ Conexión exitosa. Código: " + responseCode);                
            } else {
                System.out.println("❌ Error al conectar. Código: " + responseCode);
            }

            // Cierra la conexión
            connection.disconnect();
        } catch (MalformedURLException ex) {
            Logger.getLogger(ApiConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApiConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Digimon JsonToDigimon (String nameDigimon) {
        Digimon digimon = null;
        try {
            URL urlDigimon = new URL(DIGIMON_API + "/" + nameDigimon);
            HttpURLConnection connection = (HttpURLConnection) urlDigimon.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            Gson gson = new Gson();
            digimon = gson.fromJson(reader, Digimon.class);
            reader.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ApiConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ApiConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return digimon;
    }
}