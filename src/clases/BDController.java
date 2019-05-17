package clases;

<<<<<<< HEAD
import java.sql.*;
import java.util.ArrayList;

public class BDController {
    private Connection miConexion;
    private PreparedStatement consultaPrepExisteCandidato;
    private PreparedStatement consultaPrepExisteEvento;
    private PreparedStatement consultaPrepExisteNoticia;
    private PreparedStatement consultaPrepExisteVoluntario;
    private PreparedStatement consultaPrepExistePrograma;
    private PreparedStatement consultaCabeza;
    private PreparedStatement consultaCandidatosPorComunidad;
    private PreparedStatement consultaCandidatosPorMunicipio;
    private PreparedStatement consultaCandidatosPorNac;
    private PreparedStatement consultaCandidatosPorEur;

=======
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class BDController {
    private Connection miConexion;
>>>>>>> 7116f71dee7990ab7e4d28706a9798af249917b3

    public BDController() {
        super();
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //Configuro la conexion con la BBDD
<<<<<<< HEAD
            this.miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/partido", "root", "");
=======
            this.miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/PARTIDO_HUMANO", "root", "");
>>>>>>> 7116f71dee7990ab7e4d28706a9798af249917b3
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en constructor BDController " + e.getMessage());
        }
<<<<<<< HEAD
        String sqlconsultaPrepExisteCandidato = "SELECT * FROM candidatos WHERE cod_candidato=?";
        String sqlconsultaPrepExisteEvento = "SELECT * FROM eventos WHERE cod_evento=?";
        String sqlconsultaPrepExisteNoticia = "SELECT * FROM noticias WHERE cod_noticia=?";
        String sqlconsultaPrepExisteVoluntario = "SELECT * FROM voluntarios WHERE cod_voluntario=?";
        String sqlconsultaPrepExistePrograma = "SELECT * FROM programa WHERE cod_programa=?";
        String sqlconsultacabeza = "select * from candidatos inner join candidaturas c on candidatos.cod_candidato = c.cod_candidato inner join campanna c2 on c.cod_campaña = c2.cod_campanna where c.cabeza_lista = 'si' and c2.ambito = ?";
        String sqlconsultaCandiPorComu = "select * from candidatos inner join candidaturas c on candidatos.cod_candidato = c.cod_candidato inner join campanna c2 on c.cod_campaña = c2.cod_campanna where c2.titulo = 'Autonomica' and c2.ambito = ?";
        String sqlconsultaCandiPorMuni = "select * from candidatos inner join candidaturas c on candidatos.cod_candidato = c.cod_candidato inner join campanna c2 on c.cod_campaña = c2.cod_campanna where c2.titulo = 'Municipal' and c2.ambito = ?";
        String sqlconsultaCandiNac = "select * from candidatos inner join candidaturas c on candidatos.cod_candidato = c.cod_candidato inner join campanna c2 on c.cod_campaña = c2.cod_campanna where c2.titulo = 'Nacional'";
        String sqlconsultaCandiEur = "select * from candidatos inner join candidaturas c on candidatos.cod_candidato = c.cod_candidato inner join campanna c2 on c.cod_campaña = c2.cod_campanna where c2.titulo = 'Europa'";

        try {
            this.consultaCabeza = miConexion.prepareStatement(sqlconsultacabeza);
            this.consultaCandidatosPorComunidad = miConexion.prepareStatement(sqlconsultaCandiPorComu);
            this.consultaCandidatosPorMunicipio = miConexion.prepareStatement(sqlconsultaCandiPorMuni);
            this.consultaCandidatosPorNac = miConexion.prepareStatement(sqlconsultaCandiNac);
            this.consultaCandidatosPorEur = miConexion.prepareStatement(sqlconsultaCandiEur);
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }


    //Candidatos
    public int calcularCod_candidato() {
        int cod_candidato = 1;
        try {
            Statement miStatement = this.miConexion.createStatement();

            ResultSet rs = miStatement.executeQuery("SELECT MAX(cod_candidato) FROM candidatos");

            if (rs.first() == true) {
                cod_candidato = rs.getInt(1);
                cod_candidato++;
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en calcularCod_cANDIDATO del BDController" + e.getMessage());
        }
        return cod_candidato;
    }

//
//    public void insertarCandidatura(Candidatura candidatu) {
//        try {
//            Statement miStatement = this.miConexion.createStatement();
//            String sql = "INSERT INTO candidaturas VALUES ('" +candidatu.getCod_candidato() + "', '" + candidatu.getCod_campanna() + "', '"
//                    + candidatu.getCabeza_lista()+ "', '"
//                    +candidatu.getPosicion() +"')";
//            miStatement.executeUpdate(sql);
//            miStatement.close();
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            System.out.println("Error en insertarCandidatura del BDController" + e.getMessage());
//        }
//    }


    public void insertarCandidato(Candidato candidato) {
        try {
            Statement miStatement = this.miConexion.createStatement();
            String sql = "INSERT INTO candidatos VALUES ('" +candidato.getCod() + "', '" + candidato.getNombre() + "', '"
                    + candidato.getApellidos()  + "', '"
                    + candidato.getFecha_nac() + "', '"
                    + candidato.getLugar_nac() + "', '"
                    + candidato.getMunicipio()  + "', '"
                    + candidato.getProvincia() + "', '"
                    + candidato.getAutonomia()+"')";
            miStatement.executeUpdate(sql);
            miStatement.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en insertarCandidato del BDController" + e.getMessage());
        }
    }


    //Eventos
    public int calcularCod_Evento() {
        int cod_evento = 1;
        try {
            Statement miStatement = this.miConexion.createStatement();

            ResultSet rs = miStatement.executeQuery("SELECT MAX(cod_evento) FROM eventos");

            if (rs.first() == true) {
                cod_evento = rs.getInt(1);
                cod_evento++;
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en calcularCod_evento del BDController" + e.getMessage());
        }
        return cod_evento;
    }

    public int calcularCandidaturas() {
        int numerocan = 1;
        try {
            Statement miStatement = this.miConexion.createStatement();

            ResultSet rs = miStatement.executeQuery("SELECT count(cod_candidato) FROM candidaturas");

            if (rs.first() == true) {
                numerocan = rs.getInt(1);

            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en calcularCandidaturas del BDController" + e.getMessage());
        }
        return numerocan;
    }
    public int calcularCandidatos() {
        int numerocan = 1;
        try {
            Statement miStatement = this.miConexion.createStatement();

            ResultSet rs = miStatement.executeQuery("SELECT count(cod_candidato) FROM candidatos");

            if (rs.first() == true) {
                numerocan = rs.getInt(1);

            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en calcularCandidatos del BDController" + e.getMessage());
        }
        return numerocan;
    }

    public Boolean existeEvento(int cod_evento) {
        Boolean existe = false;

        try {
            this.consultaPrepExisteEvento.setInt(1, cod_evento);
            ResultSet rs = this.consultaPrepExisteEvento.executeQuery();

            if (rs.first() == true) {
                existe = true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en existeEvento del BDController" + e.getMessage());
        }

        return existe;
    }



    public void insertarEvento(Evento evento) {
        try {
            Statement miStatement = this.miConexion.createStatement();
            String sql = "INSERT INTO eventos VALUES ('"
                    + evento.getCod_evento()+ "', '"
                    + evento.getDescripcion()+ "', '"
                    + evento.getUbicacion()  + "', '"
                    + evento.getDia()+ "', '"
                    + evento.getHora() + "', '"
                    + evento.getNombre()  + "', '"
                    + evento.getCod_campanna() + "', '"
                    + evento.getMunicipio()+"')";
            miStatement.executeUpdate(sql);
            miStatement.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en insertarEvento del BDController" + e.getMessage());
        }
    }
    public void borrarEvento(int cod_evento) {

        try {
            Statement miStatement = this.miConexion.createStatement();
            String sql = "DELETE FROM eventos WHERE cod_evento='" + cod_evento + "'";
            miStatement.executeUpdate(sql);
            miStatement.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en borrarEventoBD del BDController" + e.getMessage());
        }
    }
    //NOTICIAS
    public Boolean existeNoticia(int cod_noticia) {
        Boolean existe = false;

        try {
            this.consultaPrepExisteNoticia.setInt(1, cod_noticia);
            ResultSet rs = this.consultaPrepExisteNoticia.executeQuery();

            if (rs.first() == true) {
                existe = true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en existeNoticia del BDController" + e.getMessage());
        }

        return existe;
    }


    public void insertarNoticia(Noticia noticia) {
        try {
            Statement miStatement = this.miConexion.createStatement();
            String sql = "INSERT INTO noticias VALUES ('"
                    + noticia.getCod_noticia()+ "', '"
                    + noticia.getTitulo()+ "', '"
                    + noticia.getCuerpo()  + "', '"
                    + noticia.getCod_campanna()+"')";
            miStatement.executeUpdate(sql);
            miStatement.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en insertarNoticia del BDController" + e.getMessage());
        }
    }
    public void borrarNoticia(int cod_noticia) {

        try {
            Statement miStatement = this.miConexion.createStatement();
            String sql = "DELETE FROM noticias WHERE cod_noticia='" + cod_noticia + "'";
            miStatement.executeUpdate(sql);
            miStatement.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en borrarNoticiaBD del BDController" + e.getMessage());
        }
    }
    //Voluntario
    public Boolean existeVoluntario(int cod_voluntario) {
        Boolean existe = false;

        try {
            this.consultaPrepExisteVoluntario.setInt(1, cod_voluntario);
            ResultSet rs = this.consultaPrepExisteVoluntario.executeQuery();

            if (rs.first() == true) {
                existe = true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en existeVoluntario del BDController" + e.getMessage());
        }

        return existe;
    }


    public void insertarVoluntario(Voluntario voluntario) {
        try {
            Statement miStatement = this.miConexion.createStatement();
            String sql = "INSERT INTO voluntarios VALUES ('"
                    + voluntario.getCod()+ "', '"
                    + voluntario.getNombre() 	+ "', '"
                    + voluntario.getApellidos()+ "', '"
                    + voluntario.getFecha_nac()  + "', '"
                    + voluntario.getEmail() + "', '"
                    + voluntario.getTelefono()  + "', '"
//															+ voluntario.get  + "', '"
//																+ noticia.getCod_campanna()
                    +"')";
            miStatement.executeUpdate(sql);
            miStatement.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en insertarVoluntario del BDController" + e.getMessage());
        }
    }
    public void borrarVoluntario(int cod_voluntario) {

        try {
            Statement miStatement = this.miConexion.createStatement();
            String sql = "DELETE FROM voluntarios WHERE cod_voluntario='" + cod_voluntario + "'";
            miStatement.executeUpdate(sql);
            miStatement.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en borrarVoluntarioBD del BDController" + e.getMessage());
        }
    }


    //Programa
    public Boolean existePrograma(int cod_programa) {
        Boolean existe = false;

        try {
            this.consultaPrepExistePrograma.setInt(1, cod_programa);
            ResultSet rs = this.consultaPrepExistePrograma.executeQuery();

            if (rs.first() == true) {
                existe = true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en existePrograma del BDController" + e.getMessage());
        }

        return existe;
    }


    public void insertarPrograma(Programa programa) {
        try {
            Statement miStatement = this.miConexion.createStatement();
            String sql = "INSERT INTO programa VALUES ('"
                    + programa.getCod_punto()+ "', '"
                    + programa.getDescripcion()+ "', '"
                    + programa.getCod_campanna()+"')";
            miStatement.executeUpdate(sql);
            miStatement.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en insertarPrograma del BDController" + e.getMessage());
        }
    }
    public void borrarPrograma(int cod_programa) {

        try {
            Statement miStatement = this.miConexion.createStatement();
            String sql = "DELETE FROM programa WHERE cod_programa='" + cod_programa + "'";
            miStatement.executeUpdate(sql);
            miStatement.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en borrarProgramaBD del BDController" + e.getMessage());
        }
    }




    public ArrayList<Programa> dame10programasEuropa() {
        ArrayList<Programa> programas = new ArrayList<Programa>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM programa limit 10");
            while (rs.next()) {
                programas.add(new Programa(rs.getInt(1),rs.getString(2) ,rs.getInt(3)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dame10programasEuropa de BDController " + e.getMessage());
        }
        return programas;
    }
    public ArrayList<Evento> dameProximosEventosAmbito() {
        ArrayList<Evento> eventos = new ArrayList<Evento>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("select eventos.*,campanna.ambito from eventos inner join campanna where campanna.cod_campanna=eventos.cod_campanna limit 5");
            while (rs.next()) {
                eventos.add(new Evento(rs.getInt(1),rs.getString(2) ,rs.getString(3) ,rs.getString(4),rs.getString(5),rs.getString(6) , rs.getInt(7),rs.getString(8),rs.getString(9)));
            }
            miStatement.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en dameProximosEventosAmbito() de BDController " + e.getMessage());
        }
        return eventos;
    }
//    public ArrayList<Evento> dameProximosEventosAmbito() {
//        ArrayList<Evento> eventos = new ArrayList<Evento>();
//        try {
//            Statement miStatement = this.miConexion.createStatement();
//            ResultSet rs = miStatement.executeQuery("SELECT * FROM eventos limit 10");
//            while (rs.next()) {
//                eventos.add(new Evento(rs.getInt(1),rs.getString(2) ,rs.getString(3) ,rs.getString(4),rs.getTime(5),rs.getString(6) , rs.getInt(7),rs.getString(8),rs.getString(9)));
//            }
//            miStatement.close();
//            rs.close();
//        } catch (SQLException e) {
//            System.out.println("Error en dameProximosEventosAmbito() de BDController " + e.getMessage());
//        }
//        return eventos;
//    }

    //Comprobamos si existe Candidato
    public Boolean existeCandidato(int cod_candidato) {
        Boolean existe = false;

        try {
            this.consultaPrepExisteCandidato.setInt(1, cod_candidato);
            ResultSet rs = this.consultaPrepExisteCandidato.executeQuery();

            if (rs.first() == true) {
                existe = true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en existeCandidato del BDController" + e.getMessage());
        }

        return existe;
    }

    //Borramos candidato
    public void borrarCandidato(int cod_candidato) {

        try {
            Statement miStatement = this.miConexion.createStatement();
            String sql = "DELETE FROM candidatos WHERE cod_candidato='" + cod_candidato + "'";
            miStatement.executeUpdate(sql);
            miStatement.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en borrarCandidatoBD del BDController" + e.getMessage());
        }
=======
>>>>>>> 7116f71dee7990ab7e4d28706a9798af249917b3
    }

    public ArrayList<Asistentes> dameAsistentes() {
        ArrayList<Asistentes> asistentes = new ArrayList<Asistentes>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM asistentes order by cod_voluntario asc");
            while (rs.next()) {
                asistentes.add(new Asistentes(rs.getInt(1), rs.getInt(2)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameEquipos de BDController " + e.getMessage());
        }
        return asistentes;
    }

    public ArrayList<Campanna> dameCampannas() {
        ArrayList<Campanna> campannas = new ArrayList<Campanna>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM campanna order by cod_campanna asc");
            while (rs.next()) {
                campannas.add(new Campanna(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameCampannas de BDController " + e.getMessage());
        }
        return campannas;
    }

    public ArrayList<Candidato> dameCandidatos() {
        ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
        try {
            Statement miStatement = this.miConexion.createStatement();
<<<<<<< HEAD
            ResultSet rs = miStatement.executeQuery("SELECT * FROM candidatos order by cod_candidato asc");

            while (rs.next()) {
                candidatos.add(new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
=======
            ResultSet rs = miStatement.executeQuery("SELECT * FROM campanna order by cod_campanna asc");
            while (rs.next()) {
                candidatos.add(new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
>>>>>>> 7116f71dee7990ab7e4d28706a9798af249917b3
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
<<<<<<< HEAD
            System.out.println("Error en dameCandidatos******************** de BDController " + e.getMessage());
        }
        return candidatos;
    }
    public ArrayList<Candidato> dameCandidatosPorComunidad(String comunidad) {
        ArrayList<Candidato> candidatosComunidad = new ArrayList<Candidato>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            consultaCandidatosPorComunidad.setString(1, comunidad);
            ResultSet rs = consultaCandidatosPorComunidad.executeQuery();
            while (rs.next()) {
                System.out.println("");
                candidatosComunidad.add(new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
            miStatement.close();
            rs.close();


        } catch (SQLException e) {
            System.out.println("Error en dameCandidatosPorComunidad******************* de BDController " + e.getMessage());
        }
        return candidatosComunidad;
    }

    public ArrayList<Candidato> dameCandidatosPorMunicipio(String municipio) {
        ArrayList<Candidato> candidatosMunicipios = new ArrayList<Candidato>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            consultaCandidatosPorMunicipio.setString(1, municipio);
            ResultSet rs = consultaCandidatosPorMunicipio.executeQuery();
            while (rs.next()) {
                System.out.println("");
                candidatosMunicipios.add(new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameCandidatosPorMunicipio******************* de BDController " + e.getMessage());
        }
        return candidatosMunicipios;
    }

    public ArrayList<Candidato> dameCandidatosPorEuropa() {
        ArrayList<Candidato> candidatosEuropa = new ArrayList<Candidato>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = consultaCandidatosPorEur.executeQuery();
            while (rs.next()) {
                System.out.println("");
                candidatosEuropa.add(new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
            miStatement.close();
            rs.close();


        } catch (SQLException e) {
            System.out.println("Error en dameCandidatosPorEuropa******************* de BDController " + e.getMessage());
        }
        return candidatosEuropa;
    }
    public ArrayList<Candidato> dameCandidatosPorNacionales() {
        ArrayList<Candidato> candidatosNacionales = new ArrayList<Candidato>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = consultaCandidatosPorNac.executeQuery();
            while (rs.next()) {
                System.out.println("nacionales");
                candidatosNacionales.add(new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
            miStatement.close();
            rs.close();


        } catch (SQLException e) {
            System.out.println("Error en dameCandidatosPorNacionales******************* de BDController " + e.getMessage());
        }
        return candidatosNacionales;
    }

    public Candidato dameCabeza(String comunidad) {
        System.out.println(comunidad);
        Candidato candidato = new Candidato();
        try {
            Statement miStatement = this.miConexion.createStatement();
            consultaCabeza.setString(1, comunidad);
            ResultSet rs = consultaCabeza.executeQuery();
            while (rs.next()) {
                candidato = new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                System.out.println("CABEZA: " + candidato.getNombre());
            }
            System.out.println(candidato.getAutonomia());
            miStatement.close();
            rs.close();


        } catch (SQLException e) {
            System.out.println("Error en dameCabeza******************* de BDController " + e.getMessage());
        }
        return candidato;
    }

    public Candidato dameCabezaNacional() {
        Candidato candidato = new Candidato();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("select * from candidatos inner join candidaturas c on candidatos.cod_candidato = c.cod_candidato inner join campanna c2 on c.cod_campaña = c2.cod_campanna where c.cabeza_lista = 'si' and c2.titulo = 'Nacional'");
            while (rs.next()) {
                candidato = new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
            }
            miStatement.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en dameCabezaNacional******************* de BDController " + e.getMessage());
        }
        return candidato;
    }
=======
            System.out.println("Error en dameCandidatos de BDController " + e.getMessage());
        }
        return candidatos;
    }
>>>>>>> 7116f71dee7990ab7e4d28706a9798af249917b3

    public ArrayList<Candidatura> dameCandidatura() {
        ArrayList<Candidatura> candidaturas = new ArrayList<Candidatura>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM candidaturas order by cod_candidato asc");
<<<<<<< HEAD

=======
>>>>>>> 7116f71dee7990ab7e4d28706a9798af249917b3
            while (rs.next()) {
                candidaturas.add(new Candidatura(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getInt(5)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameCandidatura de BDController " + e.getMessage());
        }
        return candidaturas;
    }

    public ArrayList<Evento> dameEventos() {
        ArrayList<Evento> eventos = new ArrayList<Evento>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM eventos order by cod_evento asc");
            while (rs.next()) {
<<<<<<< HEAD
                eventos.add(new Evento(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8)));
=======
                eventos.add(new Evento(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getTime(5),rs.getString(6),rs.getInt(7),rs.getString(8)));
>>>>>>> 7116f71dee7990ab7e4d28706a9798af249917b3
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameEventos de BDController " + e.getMessage());
        }
        return eventos;
    }

    public ArrayList<Noticia> dameNoticias() {
        ArrayList<Noticia> noticias = new ArrayList<Noticia>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM noticias order by cod_noticia asc");
            while (rs.next()) {
                noticias.add(new Noticia(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameNoticias de BDController " + e.getMessage());
        }
        return noticias;
    }

    public ArrayList<Programa> dameProgramas() {
        ArrayList<Programa> programas = new ArrayList<Programa>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM programa order by cod_punto asc");
            while (rs.next()) {
                programas.add(new Programa(rs.getInt(1),rs.getString(2),rs.getInt(3)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameProgramas de BDController " + e.getMessage());
        }
        return programas;
    }

    public ArrayList<Voluntariado> dameVoluntariados() {
        ArrayList<Voluntariado> voluntariados = new ArrayList<Voluntariado>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM voluntariados order by cod_voluntariado asc");
            while (rs.next()) {
                voluntariados.add(new Voluntariado(rs.getInt(1),rs.getInt(3)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameVoluntariados de BDController " + e.getMessage());
        }
        return voluntariados;
    }

    public ArrayList<Noticia> dame4NoticiasCampanna() {
        ArrayList<Noticia> noticias = new ArrayList<Noticia>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("select * from noticias where cod_campanna in (select campanna.cod_campanna from campanna where campanna.titulo = 'Europa') limit 4");
            while (rs.next()) {
                noticias.add(new Noticia(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dame4NoticiasCampanna de BDController " + e.getMessage());
        }
        return noticias;
    }

    public ArrayList<Evento> dame5proximosEventos() {
        ArrayList<Evento> eventos = new ArrayList<Evento>();
        try {
            Statement miStatement = this.miConexion.createStatement();
<<<<<<< HEAD
            ResultSet rs = miStatement.executeQuery("SELECT * FROM eventos order by cod_evento desc limit 5");
            while (rs.next()) {
                System.out.println("");
                eventos.add(new Evento(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8)));
=======
            ResultSet rs = miStatement.executeQuery("SELECT * FROM eventos WHERE DATE(dia)>CURDATE() order by dia limit 5;");
            while (rs.next()) {
                eventos.add(new Evento(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getTime(5),rs.getString(6),rs.getInt(7),rs.getString(8)));
>>>>>>> 7116f71dee7990ab7e4d28706a9798af249917b3
            }
            miStatement.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en dame5proximosEventos de BDController " + e.getMessage());
        }
        return eventos;
    }

    public ArrayList<Programa> dame10primerosPuntosPrograma() {
        ArrayList<Programa> programas = new ArrayList<Programa>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("select * from programa where cod_campanna in (select cod_campanna from campanna where titulo = 'nacional') limit 10");
            while (rs.next()) {
                programas.add(new Programa(rs.getInt(1),rs.getString(2),rs.getInt(3)));
            }
            miStatement.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en dame10primerosPuntosPrograma de BDController " + e.getMessage());
        }
        return programas;
    }
<<<<<<< HEAD

=======
>>>>>>> 7116f71dee7990ab7e4d28706a9798af249917b3
}