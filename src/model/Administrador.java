package model;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class Administrador {
    
    private String nome;
    private String senha;
    private String email;
    private String numeroRegistro;
    private String sexo; 

  public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("nome", nome);
        map.put("senha", senha);
        map.put("email", email);
        map.put("numeroRegistro", numeroRegistro);
        map.put("sexo", sexo);
        return map;
    }
  public Administrador fromMap(Map<String, Object> map) {
        Administrador administrador = new Administrador();
        administrador.setNome((String) map.get("nome"));
        administrador.setSenha((String) map.get("senha"));
        administrador.setEmail((String) map.get("email"));
        administrador.setNumeroRegistro((String) map.get("numeroRegistro"));
        administrador.setSexo((String) map.get("sexo"));
        return administrador;
    }
}
