/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;


/**
 *
 * @author julio
 */
@Data
public class Veiculos {
    
    private String modelo;
    private String placa;
    private String cor;
    private int quilometragem;
    private int anoVeiculo;
    private String chassi;
    private String renavam;
    private Boolean reservado;
    
    public Map<String, Object> toMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("modelo",modelo);
        map.put("placa",placa);
        map.put("cor",cor);
        map.put("quilometragem",quilometragem);
        map.put("anoVeiculo",anoVeiculo);
        map.put("renavam", renavam);
        map.put("chassi", chassi);
        map.put("reservado", reservado);
        return map;
         }
    
    public  Veiculos fromMap(Map<String, Object> map) {
        Veiculos veiculo = new Veiculos();
        veiculo.setModelo((String) map.get("modelo"));
        veiculo.setPlaca((String) map.get("placa"));
        veiculo.setCor((String) map.get("cor"));
        veiculo.setQuilometragem((int) map.get("quilometragem"));
        veiculo.setAnoVeiculo((int) map.get("anoVeiculo"));
        veiculo.setChassi((String) map.get("chassi"));
        veiculo.setRenavam((String) map.get("renavam"));
        veiculo.setReservado((Boolean) map.get("reservado"));
        return veiculo;
    }
}
