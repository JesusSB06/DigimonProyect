/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digimonproyect.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    private static final String DIGIMON_INDIVIDUAL = "https://digi-api.com/api/v1/digimon/";

    public static void askApi(String nameDigimon) {
        try {
            URL urlJson = new URL(DIGIMON_INDIVIDUAL + nameDigimon);
            HttpURLConnection connection = (HttpURLConnection) urlJson.openConnection();
            connection.setRequestMethod("GET");

            // Conecta con el servidor
            int responseCode = connection.getResponseCode();

            // Verifica si la conexión fue exitosa
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("✅ Conexión exitosa. Código: " + responseCode);

                // Leer la respuesta (opcional)
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Mostrar el JSON recibido
                System.out.println("Respuesta: " + response.toString());
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
}
