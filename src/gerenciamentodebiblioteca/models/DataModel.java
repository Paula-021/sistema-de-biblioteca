/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamentodebiblioteca.models;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author anapa
 */
public class DataModel {
    

    public LocalDate calcularDataFim(LocalDate dataInicio) {

        GregorianCalendar calendario = new GregorianCalendar();
        calendario.set(Calendar.MONTH, dataInicio.getMonthValue() - 1); //setando o calendário (primeiro parametro -> o que iremos setar do calendário, que no caso é o mês) (Segundo parametro: o numero do mês de 0 a 11)
        int qntDiasDoMes = calendario.getActualMaximum(Calendar.DAY_OF_MONTH); //variável para armazenar a quantidade de dias do mês. o método getActualMaximum retorna a qnt de dias do mês (parametro: o que queremos o máximo)

        int diasRestantes = qntDiasDoMes - dataInicio.getDayOfMonth(); 
        int diasRestantesValorAbsoluto = Math.abs(diasRestantes); //não precisa usar isso aqui (somente exemplo de converter para valor absoluto)
        System.out.println(qntDiasDoMes);
        
        System.out.println("Dias restantes: " + diasRestantes);
        System.out.println("Dias restantes valor absoluto: " + diasRestantesValorAbsoluto);
        
        LocalDate dataFim = null;
        if (diasRestantes >= 7) {
            int diaDataFim = dataInicio.getDayOfMonth() + 7;
            int mesDataFim = dataInicio.getMonthValue();
            int anoDataFim = dataInicio.getYear();

            dataFim = LocalDate.of(anoDataFim, mesDataFim, diaDataFim);
           
        }else if(dataInicio.getMonthValue() == 12){ // 28/12/2024
                                                    // 04/01/2024
                                                    
                                                    
            int diaDataFim = (dataInicio.getDayOfMonth() + 7) - qntDiasDoMes; //35 - 31 = 4
            int mesDataFim = 1;    
            int anoDataFim = dataInicio.getYear() + 1;

            dataFim = LocalDate.of(anoDataFim, mesDataFim, diaDataFim);
            
        }else if(diasRestantes < 7) {
            int diaDataFim = (dataInicio.getDayOfMonth() + 7) - qntDiasDoMes; //35 - 31 = 4
            int mesDataFim = dataInicio.getMonthValue() + 1;    
            int anoDataFim = dataInicio.getYear();

            dataFim = LocalDate.of(anoDataFim, mesDataFim, diaDataFim);
        }

        return dataFim;
    }
    }
    

