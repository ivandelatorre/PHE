package clases;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;

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
    private PreparedStatement consulta5puntos;
    private PreparedStatement consultaPuntosMunicipios;
    private PreparedStatement consulta10puntos;


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
            this.miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/partido", "root", "");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en constructor BDController " + e.getMessage());
        }
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
        String sqlconsulta5puntos = "select * from programa where cod_campanna in (select cod_campanna from campanna where ambito = ?) limit 5";
        String sqlconsultapuntosmunicipios = "select * from programa where cod_campanna in (select cod_campanna from campanna where ambito = ?)";
        String sqlconsulta10puntos = "select * from programa where cod_campanna in (select cod_campanna from campanna where titulo = ?) limit 10";

        try {
            this.consultaCabeza = miConexion.prepareStatement(sqlconsultacabeza);
            this.consultaCandidatosPorComunidad = miConexion.prepareStatement(sqlconsultaCandiPorComu);
            this.consultaCandidatosPorMunicipio = miConexion.prepareStatement(sqlconsultaCandiPorMuni);
            this.consultaCandidatosPorNac = miConexion.prepareStatement(sqlconsultaCandiNac);
            this.consultaCandidatosPorEur = miConexion.prepareStatement(sqlconsultaCandiEur);
            this.consulta5puntos = miConexion.prepareStatement(sqlconsulta5puntos);
            this.consultaPuntosMunicipios = miConexion.prepareStatement(sqlconsultapuntosmunicipios);
            this.consulta10puntos = miConexion.prepareStatement(sqlconsulta10puntos);
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public Hashtable<String,Candidato> dameCandidat(int codigo) {
        Hashtable<String,Candidato> candidatos = new Hashtable<String,Candidato>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM candidatos where cod_candidato="+codigo);

            while (rs.next()) {
                Candidato cand=new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                candidatos.put("1",cand);
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameCandidat******************** de BDController " + e.getMessage());
        }
        return candidatos;
    }


    public ArrayList<Voluntario> dameVoluntarios() {
        ArrayList<Voluntario> voluntarios = new ArrayList<Voluntario>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT cod_voluntario,nombre,apellidos,fecha_nac,email,telefono FROM VOLUNTARIOS");



            while (rs.next()) {
                voluntarios.add(new Voluntario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));

                System.out.println(voluntarios.get(0).getNombre() + "--NOMBRE--");
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameVoluntarios de BDController " + e.getMessage());
        }
        return voluntarios;
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


    public void insertarCandidatura(Candidatura candidatu) {
        try {
            Statement miStatement = this.miConexion.createStatement();
            String sql = "INSERT INTO candidaturas VALUES ('" +candidatu.getCod_candidato() + "', '" + candidatu.getCod_campanna() + "', '"
                    + candidatu.getCabeza_lista()+ "', '"
                    +candidatu.getPosicion() +"')";
            miStatement.executeUpdate(sql);
            miStatement.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en insertarCandidatura del BDController" + e.getMessage());
        }
    }

    public ArrayList<Candidato> dameCandidato(int codigo) {
        ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM candidatos where cod_candidato="+codigo);

            while (rs.next()) {
                candidatos.add(new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameCandidato******************** de BDController " + e.getMessage());
        }
        return candidatos;
    }

    public ArrayList<Evento> dameEvento(int codigo) {
        ArrayList<Evento> eventos = new ArrayList<Evento>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM eventos where cod_evento="+codigo);
            while (rs.next()) {
                eventos.add(new Evento(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameEvento de BDController " + e.getMessage());
        }
        return eventos;
    }

    public void insertarCandidato(Candidato candidato) {
        try {
            Statement miStatement = this.miConexion.createStatement();
            String sql = "INSERT INTO candidatos (nombre, apellidos, fecha_nac, lugar_nac, municipio, provincia, autonomia, descripcion)  VALUES ('"
                    + candidato.getNombre() + "', '"
                    + candidato.getApellidos()  + "', '"
                    + candidato.getFecha_nac() + "', '"
                    + candidato.getLugar_nac() + "', '"
                    + candidato.getMunicipio()  + "', '"
                    + candidato.getProvincia() + "', '"
                    + candidato.getAutonomia() + "', '"
                     + candidato.getDescripcion()+"')";
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

    public int calcularCampanna() {
        int numerocan = 1;
        try {
            Statement miStatement = this.miConexion.createStatement();

            ResultSet rs = miStatement.executeQuery("SELECT count(cod_campanna) FROM campanna");

            if (rs.first() == true) {
                numerocan = rs.getInt(1);

            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en calcularCampanna del BDController" + e.getMessage());
        }
        return numerocan;
    }

    public int calcularEventos() {
        int numerocan = 1;
        try {
            Statement miStatement = this.miConexion.createStatement();

            ResultSet rs = miStatement.executeQuery("SELECT count(cod_evento) FROM eventos");

            if (rs.first() == true) {
                numerocan = rs.getInt(1);

            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en calcularEvento del BDController" + e.getMessage());
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

    public void insertarAsistentes(int codA, int codC) {
        try {
            Statement miStatement = this.miConexion.createStatement();
            String sql = "INSERT INTO asistentes VALUES ("
                    + codA 	+ ", "
                    + codC + ")";
            miStatement.executeUpdate(sql);
            miStatement.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en insertarAsistentes del BDController" + e.getMessage());
        }
    }

    public void insertarVoluntario(Voluntario voluntario) {
        try {
            Statement miStatement = this.miConexion.createStatement();
            String sql = "INSERT INTO voluntarios(nombre, apellidos, fecha_nac, email, telefono) VALUES ('"
                    + voluntario.getNombre() 	+ "', '"
                    + voluntario.getApellidos()+ "', '"
                    + voluntario.getFecha_nac()  + "', '"
                    + voluntario.getEmail() + "', '"
                    + voluntario.getTelefono()  + "')";
            System.out.println(sql);
            miStatement.execute(sql);
            miStatement.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en insertarVoluntario del BDController" + e.getMessage());
        }
    }

    public void insertarVoluntariados(int codA, int codC) {
        try {
            Statement miStatement = this.miConexion.createStatement();
            String sql = "INSERT INTO voluntariados VALUES ("
                    + codA 	+ ", "
                    + codC + ")";
            miStatement.executeUpdate(sql);
            miStatement.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Error en insertarVoluntariados del BDController" + e.getMessage());
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

    public int dameIdUltimoVoluntario() {
        int id = -1;
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT cod_voluntario FROM voluntarios order by cod_voluntario desc limit 1");
            while (rs.next()) {
                id = rs.getInt(1);
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error en dameIdUltimoVoluntario de BDController " + e.getMessage());
        }
        return id;
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
            ResultSet rs = miStatement.executeQuery("SELECT * FROM candidatos order by cod_candidato asc");
            while (rs.next()) {
                candidatos.add(new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
            }
            miStatement.close();
            rs.close();

        } catch (SQLException e) {
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
                candidatosComunidad.add(new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
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
                candidatosMunicipios.add(new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
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
                candidatosEuropa.add(new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
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
                candidatosNacionales.add(new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
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
                candidato = new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));

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
                candidato = new Candidato(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9));
            }
            miStatement.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en dameCabezaNacional******************* de BDController " + e.getMessage());
        }
        return candidato;
    }

    public ArrayList<Candidatura> dameCandidatura() {
        ArrayList<Candidatura> candidaturas = new ArrayList<Candidatura>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            ResultSet rs = miStatement.executeQuery("SELECT * FROM candidaturas order by cod_candidato asc");

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
                eventos.add(new Evento(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8)));
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
            ResultSet rs = miStatement.executeQuery("SELECT * FROM eventos order by cod_evento desc limit 5");
            while (rs.next()) {
                eventos.add(new Evento(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8)));
            }
            miStatement.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en dame5proximosEventos de BDController " + e.getMessage());
        }
        return eventos;
    }

    public ArrayList<Programa> dame10primerosPuntosPrograma(String ambito) {
        ArrayList<Programa> programas = new ArrayList<Programa>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            consulta10puntos.setString(1, ambito);
            ResultSet rs = consulta10puntos.executeQuery();
            while (rs.next()) {
                programas.add(new Programa(rs.getInt(1),rs.getString(2),rs.getInt(3), rs.getString(4)));
            }
            miStatement.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en dame10primerosPuntosPrograma de BDController " + e.getMessage());
        }
        return programas;
    }

    public ArrayList<Programa> dame5primerosPuntosPrograma(String comunidad) {
        ArrayList<Programa> programas = new ArrayList<Programa>();
        try {
            Statement miStatement = this.miConexion.createStatement();

            consulta5puntos.setString(1, comunidad);
            ResultSet rs = consulta5puntos.executeQuery();
            while (rs.next()) {
                programas.add(new Programa(rs.getInt(1),rs.getString(2),rs.getInt(3), rs.getString(4)));
            }
            miStatement.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en dame5primerosPuntosPrograma de BDController " + e.getMessage());
        }
        return programas;
    }

    public ArrayList<Programa> damePuntosMunicipio(String municipio) {
        ArrayList<Programa> programas = new ArrayList<Programa>();
        try {
            Statement miStatement = this.miConexion.createStatement();
            consultaPuntosMunicipios.setString(1, municipio);
            ResultSet rs = consultaPuntosMunicipios.executeQuery();
            while (rs.next()) {
                programas.add(new Programa(rs.getInt(1),rs.getString(2),rs.getInt(3), rs.getString(4)));
            }
            miStatement.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error en dame5primerosPuntosPrograma de BDController " + e.getMessage());
        }
        return programas;
    }

}