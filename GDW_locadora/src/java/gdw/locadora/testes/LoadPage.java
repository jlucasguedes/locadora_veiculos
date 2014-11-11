/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.testes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class LoadPage {

    public void getPage(URL url, File file) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter out = new BufferedWriter(new FileWriter(file));

        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            //Imprime a página no console
            System.out.println(inputLine);
            //Grava pagina no arquivo
            out.write(inputLine);
            out.newLine();
        }

        in.close();
        out.flush();
        out.close();
    }

    public static void main(String[] args) {
        URL url = null;
        File file = new File("c:\\joao_lucas.html");
        try {
            url = new URL("http://semed.palmas.to.gov.br/sge/indexrelatorio.php?url=CE83A426EE754E1B8772E50528BCA8D6&idpessoa=93518&idunidade=15&datalotacao=2013-10-02&idlotacao=7766");
            new LoadPage().getPage(url, file);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
