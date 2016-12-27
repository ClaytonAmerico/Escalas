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

import br.com.master.escalas.model.Funcionario;

@Repository
public class FuncionarioDAO {

	private static final String C_INSERT = "insert into ESC_FUNCIONARIO (ID_SETOR, COD_FUN, NOME, CARTEIRA, ID_HORA, SITUACAO) values (?, ?, ?, ?, ?, ?)";
	private static final String R_SELECT = "select ID_SETOR, COD_FUN NOME CARTEIRA ID_HORA SITUACAO from ESC_FUNCIONARIO where COD_FUN = ?";
	private static final String U_UPDATE = "update ESC_FUNCIONARIO set COD_FUN = ?, NOME = ?, CARTEIRA = ?, ID_HORA = ?, SITUACAO = ? where COD_FUN = ?";
	private static final String D_REMOVE = "delete from ESC_FUNCIONARIO where COD_FUN = ?";
	private static final String FIND_ALL = "select * from ESC_FUNCIONARIO";

	private final Connection connection;

	@Autowired
	public FuncionarioDAO(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void insert(Funcionario funcionario) {
		try (PreparedStatement pstm = this.connection.prepareStatement(C_INSERT)) {
			pstm.setLong(1, funcionario.getIdS());
			pstm.setLong(2, funcionario.getIdF());
			pstm.setString(3, funcionario.getNome());
			pstm.setString(4, funcionario.getCarteira());
			pstm.setLong(5, funcionario.getIdH());
			pstm.setInt(6, funcionario.getSituacao());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Funcionario select(Long id) {
		Funcionario funcionario = new Funcionario();
		funcionario.setIdF(id);
		try (PreparedStatement pstm = this.connection.prepareStatement(R_SELECT)){
			pstm.setLong(1, funcionario.getIdF());
			try (ResultSet rs = pstm.executeQuery()) {
				if(rs.next()) {
					funcionario.setIdS(rs.getLong("ID_SETOR"));
					funcionario.setIdF(rs.getLong("COD_FUN"));
					funcionario.setNome(rs.getString("NOME"));
					funcionario.setCarteira(rs.getString("CARTEIRA"));
					funcionario.setIdH(rs.getLong("ID_HORA"));
					funcionario.setSituacao(rs.getInt("SITUACAO"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return funcionario;
	}
	
	public void update(Funcionario funcionario) {
		try (PreparedStatement pstm = this.connection.prepareStatement(U_UPDATE)) {
			pstm.setLong(1, funcionario.getIdS());
			pstm.setLong(2, funcionario.getIdF());
			pstm.setString(3, funcionario.getNome());
			pstm.setString(4, funcionario.getCarteira());
			pstm.setInt(5, funcionario.getSituacao());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Funcionario funcionario) {
		try (PreparedStatement pstm = this.connection.prepareStatement(D_REMOVE)) {
			pstm.setLong(1, funcionario.getIdF());
			pstm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Funcionario> getFuncionarios() {
		try (PreparedStatement pstm = this.connection.prepareStatement(FIND_ALL); ResultSet rs = pstm.executeQuery()) {
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setIdS(rs.getLong("ID_SETOR"));
				funcionario.setIdF(rs.getLong("COD_FUN"));
				funcionario.setNome(rs.getString("NOME"));
				funcionario.setCarteira(rs.getString("CARTEIRA"));
				funcionario.setSituacao(rs.getInt("SITUACAO"));
				funcionarios.add(funcionario);
			}
			return funcionarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
