/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;


@Data
public class Motorista {
 
    private Boolean autorizacaoReserva;
    private LocalDate dataVencimentoCarteira;
    private String tipoCnh;
    private String numeroCarteira; //String pois não será feito contas com o valor e também podem ter zeros a esquerda;s
    private String nome;
    private int quantidadeViagens;
    private String email;
    private String senha;
    private String numeroRegistro;
    
     public Map<String, Object> toMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("autorizacaoReserva", autorizacaoReserva);
        map.put("dataVencimentoCarteira",dataVencimentoCarteira);
        map.put("tipoCnh",tipoCnh);
        map.put("numeroCarteira",numeroCarteira);
        map.put("nome",nome);
        map.put("quantidadeViagens",quantidadeViagens);
        map.put("email", email);
        map.put("senha", senha);
        map.put("numeroRegistro",numeroRegistro);
        return map;
     }
    public Motorista fromMap(Map<String,Object>map){
      Motorista motorista = new Motorista();
        motorista.setAutorizacaoReserva((Boolean) map.get("autorizacaoReserva"));
        motorista.setDataVencimentoCarteira((LocalDate) map.get("dataVencimentoCarteira"));
        motorista.setTipoCnh((String) map.get("tipoCnh"));
        motorista.setNumeroCarteira((String) map.get("numeroCarteira"));
        motorista.setNome((String) map.get("nome"));
        motorista.setQuantidadeViagens((int) map.get("quantidadeViagens"));
        motorista.setEmail((String) map.get("email"));
        motorista.setSenha((String) map.get("senha"));
        motorista.setNumeroRegistro((String)map.get("numeroRegistro"));
        return motorista;
    }
}
