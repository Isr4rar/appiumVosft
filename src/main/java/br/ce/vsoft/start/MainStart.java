package br.ce.vsoft.start;

import br.ce.vsoft.appium.SendMensage;
import br.ce.vsoft.web.CreationArticle;

import java.io.IOException;

public class MainStart {

    public static void main(String[] args) throws IOException, InterruptedException {

        switch (System.getenv("$(Build.SourceBranchName)")){
            case "Emergencia":
                CreationArticle creationArticle = new CreationArticle();
                creationArticle.criarArtigo();
                break;
            case "Enviar Mensagem":
                SendMensage sendMensage = new SendMensage();
                sendMensage.enviarMensagem();
                break;
        }
    }
}
