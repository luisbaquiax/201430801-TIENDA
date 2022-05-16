/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.utiles;

/**
 *
 * @author luis
 */
public class ContendioReporte {

    private String headerHTML;
    private String footerHTML;
    private String tableHeader;
    private String tableFooter;

    public ContendioReporte() {

    }

    /**
     * Reotorna el cuerpo del documento HTML
     *
     * @param contenido
     * @return
     */
    public String getBody(String contenido) {

        String html = "<!doctype html>\n"
                + "<html lang=\"en\">\n"
                + "  <head>\n"
                + "    <!-- Required meta tags -->\n"
                + "    <meta charset=\"utf-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
                + "\n"
                + "    <!-- Bootstrap CSS -->\n"
                + "    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\" integrity=\"sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn\" crossorigin=\"anonymous\">\n"
                + "\n"
                + "    <title>Reportes</title>\n"
                + "  </head>\n"
                + "  <body>\n"
                + "\n"
                + contenido
                + "\n"
                + "    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->\n"
                + "    <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\" integrity=\"sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\" crossorigin=\"anonymous\"></script>\n"
                + "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF\" crossorigin=\"anonymous\"></script>\n"
                + "\n"
                + "  </body>\n"
                + "</html>";
        return html;
    }
;
}
