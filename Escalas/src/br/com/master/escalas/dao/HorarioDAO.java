package br.com.master.escalas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.master.escalas.model.Horario;

@Repository
public class HorarioDAO {
	
	private static final String C_INSERT = "insert into ESC_HORARIO (INICIO, TERMINO) values (?, ?)";
	private static final String R_SELECT = "select ID INICIO TERMINO from ESC_HORARIO where ID = ?";
	private static final String U_UPDATE = "update ESC_HORARIO set INICIO = ?, TERMINO = ? where ID = ?";
	private static final String D_REMOVE = "delete from ESC_SETOR where ID = ?";
	private static final String FIND_ALL = "select * from ESC_HORARIO order by INICIO";

	private Connection connection;
	
	@Autowired
	public HorarioDAO(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void insert(Horario horario) {
		try (PreparedStatement pstm = this.connection.prepareStatement(C_INSERT)) {
			pstm.setTime(1, horario.getInicio());
			pstm.setTime(2, horario.getTermino());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}
	
	public Horario select(Long id) {
		Horario horario = new Horario();
		horario.setIdH(id);		
		try (PreparedStatement pstm = this.connection.prepareStatement(R_SELECT)) {
			pstm.setLong(1, horario.getIdH());
			try (ResultSet rs = pstm.executeQuery()) {
				if (rs.next()) {
					horario.setIdH(rs.getLong("ID"));
					horario.setInicio(rs.getTime("INICIO"));
					horario.setTermino(rs.getTime("TERMINO"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return horario;
	}
	
	public void update(Horario horario) {
		try (PreparedStatement pstm = this.connection.prepareStatement(U_UPDATE)){
			pstm.setTime(1, horario.getInicio());
			pstm.setTime(2, horario.getTermino());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Horario horario) {
		try (PreparedStatement pstm = this.connection.prepareStatement(D_REMOVE)) {
			pstm.setLong(1, horario.getIdH());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Horario> getHorarios() {
		try (PreparedStatement pstm = this.connection.prepareStatement(FIND_ALL); ResultSet rs = pstm.executeQuery()) {
			List<Horario> horarios = new ArrayList<Horario>();
			while(rs.next()){
				Horario horario = new Horario();
				horario.setIdH(rs.getLong("ID"));
				horario.setInicio(rs.getTime("INICIO"));
				horario.setTermino(rs.getTime("TERMINO"));
				horarios.add(horario);
			}
			return horarios;			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
