package mx.itson.identifacilmx.negocio;

import javax.swing.JOptionPane;


/**
 * Contiene métodos para recibir los datos del usuario y generar la CURP.
 * @author Jose Manuel Leyva Munguia
 * @version v1.0
 */
public class Generador {

    //Variables para almacenar los datos necesarios para generar la CURP.
    String nombre = "";
    String apellidoP = "";
    String apellidoM = "";
    String sexo = "";
    String estado = "";
    Integer dia = 0, año = 0, mes = 0;
    char a, b;
    public String curpg = "";

    // Obtiene la fecha de nacimiento
    public void getFecha(String a, String b, String c) {

        dia = Integer.parseInt(a);
        mes = Integer.parseInt(b);
        año = Integer.parseInt(c);

    }

    // Obtiene el sexo
    public void getSexo(String radio) {
        sexo = radio;
    }

    // Obtiene el estado de nacimiento
    public void getEstado(String boxEstado) {
        estado = boxEstado;
    }

    // Obtiene el nombre completo
    public void getNombrecompleto(String a, String b, String c) {
        nombre = a.toUpperCase(); 
        apellidoP = b.toUpperCase();
        apellidoM = c.toUpperCase();
    }

    // Genera la CURP
    public String curpGen() {
        // Inicial del apellido paterno
        char c1 = apellidoP.charAt(0); 
        
        // Primera vocal interna del apellido paterno
        char c2 = 0;
        for (int i = 1; i < apellidoP.length(); i++) {
            char l = apellidoP.charAt(i);
            if (l == 'A' || l == 'E' || l == 'I' || l == 'O' || l == 'U') {
                c2 = l;
                break;
            }
        }
        
        // Inicial del apellido materno
        char c3 = 0;

        if (apellidoM.isEmpty()) {
            String vacio = "X";
            c3 = vacio.charAt(0);
        } else {
            c3 = apellidoM.charAt(0);
        }
        
        // Inicial del nombre
        char c4 = 0;

        // Verifica si el nombre es compuesto y contiene "Jose" o "Maria"
        if (nombre.contains(" ")) {
            String[] nombres = nombre.split(" ");
            String primerNombre = nombres[0];
            String segundoNombre = nombres[1];

            if (primerNombre.equalsIgnoreCase("jose") || primerNombre.equalsIgnoreCase("maria")) {
                c4 = segundoNombre.charAt(0);
            } else {
                c4 = primerNombre.charAt(0);
            }
        } else {
            c4 = nombre.charAt(0);
        }

        String year = String.valueOf(año);
        // Tercer carácter del año de nacimiento
        char c5 = year.charAt(2);
        // Cuarto carácter del año de nacimiento
        char c6 = year.charAt(3);
        
        
        String month = String.valueOf(mes);
        // Primer carácter del mes de nacimiento
        char c7 = 0;
        // Primer carácter del mes de nacimiento
        char c8 = 0;

        // Formatea el mes con dos carácteres, agregando un '0' si es menor que 10
        if (mes < 10) {
            c7 = '0';
            c8 = month.charAt(0);
        } else {
            c7 = month.charAt(0);
            c8 = month.charAt(1);
        }

        String day = String.valueOf(dia);
        
        // Primer carácter del dia de nacimiento
        char c9 = 0;
        // Segundo carácter del dia de nacimiento
        char c10 = 0;

        // Formatea el día con dos carácteres, agregando un '0' si es menor que 10
        if (dia < 10) {
            c9 = '0';
            c10 = day.charAt(0);
        } else {
            c9 = day.charAt(0);
            c10 = day.charAt(1);
        }
        
        // Sexo del usuario
        char c11 = sexo.charAt(0);
        
        entidadFederativa();
        //Primer carácter de la entidad federativa
        char c12 = a;
        //Segundo carácter de la entidad federativa
        char c13 = b;

        // Primera consonante en el apellido paterno
        char c14 = 0;

        for (int i = 1; i < apellidoP.length(); i++) {
            char l = apellidoP.charAt(i);
            if (l != 'A' && l != 'E' && l != 'I' && l != 'O' && l != 'U') { // excluimos a las vocales
                c14 = l;
                break;
            }
        }
        
        // Primera consonante en el apellido materno
        char c15 = 0;
      
        for (int i = 1; i < apellidoM.length(); i++) {
            char l = apellidoM.charAt(i);
            if (l != 'A' && l != 'E' && l != 'I' && l != 'O' && l != 'U') { // excluimos a las vocales
                c15 = l;
                break;
            }
        }
        
        //Primera consonante del nombre
        char c16 = 0;

        // Verifica si el nombre es compuesto y empieza con "Jose" o "Maria"
        if (nombre.contains(" ")) {
            String[] nombres = nombre.split(" ");
            String primerNombre = nombres[0];
            String segundoNombre = nombres[1];

            if (primerNombre.equalsIgnoreCase("jose") || primerNombre.equalsIgnoreCase("maria")) {
                for (int i = 1; i < segundoNombre.length(); i++) {
                    char l = segundoNombre.charAt(i);
                    if (l != 'A' && l != 'E' && l != 'I' && l != 'O' && l != 'U') {
                        c16 = l;
                        break;
                    }
                }
                } else {
                    for (int i = 1; i < primerNombre.length(); i++) {
                        char l = primerNombre.charAt(i);
                    if (l != 'A' && l != 'E' && l != 'I' && l != 'O' && l != 'U') {
                        c16 = l;
                        break;
                    }
                }
            }
        } else {
            for (int i = 1; i < nombre.length(); i++) {
                char l = nombre.charAt(i);
                if (l != 'A' && l != 'E' && l != 'I' && l != 'O' && l != 'U') {
                    c16 = l;
                    break;
                }
            }
        }
        
        // Convertir la cadena a un entero
        int selectedYear = Integer.parseInt(year); 
        
        // Valor de la homoclave
        char c17; 

        if (selectedYear <= 1999) {
            c17 = '0'; // Si el año es 1999 o menos
        } else {
            c17 = 'A'; // Si el año es 2000 o más
        }
        
        //Dígito verificador
        String b = "1";
        char c18 = b.charAt(0);
        
        // Formación de la CURP
        curpg = String.valueOf(c1 + "" + c2 + "" + c3 + "" + c4 + "" + c5 + "" + c6 + "" + c7 + "" + c8 + "" + c9 + "" + c10 + "" + c11 + "" + c12 + "" + c13 + "" + c14 + "" + c15 + "" + c16 + "" + c17 + "" + c18);
        // Muestra la CURP en una ventana de mensaje
        JOptionPane.showMessageDialog(null, curpg);
        // Devuelve la CURP formada
        return curpg;
    }

    // Método para asignar las letras correspondientes a la entidad federativa
    public void entidadFederativa() {

        switch (estado) {

            case "Aguascalientes":
                a = 'A';
                b = 'S';
                break;

            case "Baja California":
                a = 'B';
                b = 'C';
                break;

            case "Baja California Sur":
                a = 'B';
                b = 'S';

                break;

            case "Campeche":
                a = 'C';
                b = 'C';
                break;

            case "Coahuila de Zaragoza":
                a = 'C';
                b = 'L';
                break;

            case "Colima":
                a = 'C';
                b = 'M';
                break;

            case "Chiapas":
                a = 'C';
                b = 'S';
                break;

            case "Chihuahua":
                a = 'C';
                b = 'H';
                break;

            case "Ciudad de México":
                a = 'D';
                b = 'F';
                break;

            case "Durango":
                a = 'D';
                b = 'G';
                break;

            case "Guanajuato":
                a = 'G';
                b = 'T';
                break;

            case "Guerrero":
                a = 'G';
                b = 'R';
                break;

            case "Hidalgo":
                a = 'H';
                b = 'G';
                break;

            case "Jalisco":
                a = 'J';
                b = 'C';
                break;

            case "Estado de México":
                a = 'M';
                b = 'C';
                break;

            case "Michoacan de Ocampo":
                a = 'M';
                b = 'N';
                break;

            case "Morelos":
                a = 'M';
                b = 'S';
                break;

            case "Nayarit":
                a = 'N';
                b = 'T';
                break;

            case "Nuevo Leon":
                a = 'N';
                b = 'L';
                break;

            case "Oaxaca":
                a = 'O';
                b = 'C';
                break;

            case "Puebla":
                a = 'P';
                b = 'L';
                break;

            case "Queretaro de Arteaga":
                a = 'Q';
                b = 'T';
                break;

            case "Quintana Roo":
                a = 'Q';
                b = 'R';
                break;

            case "San Luis Potosi":
                a = 'S';
                b = 'P';
                break;

            case "Sinaloa":
                a = 'S';
                b = 'L';
                break;

            case "Sonora":
                a = 'S';
                b = 'R';
                break;

            case "Tabasco":
                a = 'T';
                b = 'C';
                break;

            case "Tamaulipas":
                a = 'T';
                b = 'S';
                break;
            case "Tlaxcala":
                a = 'T';
                b = 'L';
                break;

            case "Veracruz":
                a = 'V';
                b = 'Z';
                break;

            case "Yucatan":
                a = 'Y';
                b = 'N';
                break;

            case "Zacatecas":
                a = 'Z';
                b = 'S';
                break;
            case "Nacido en el Extranjero":
                a = 'N';
                b = 'E';
        }
    }

}
