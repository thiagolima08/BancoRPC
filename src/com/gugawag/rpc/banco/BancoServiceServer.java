package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private Map<String, Double> saldoContas;

    public List<Conta> contaLista;

    public BancoServiceServer() throws RemoteException {
        saldoContas = new HashMap<>();
        saldoContas.put("1", 100.0);
        saldoContas.put("2", 156.0);
        saldoContas.put("3", 950.0);

        contaLista = new ArrayList<>();
        contaLista.add(new Conta("1234",100));
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        return saldoContas.get(conta);
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return saldoContas.size();
    }

    @Override
    public void adicionarConta(String numero, double saldo) throws RemoteException {
        Conta conta = new Conta(numero,saldo);
        contaLista.add(conta);
    }

    public Conta pesquisarConta(String numero) throws RemoteException {
        if(contaLista.size()>0) {
            for (Conta conta : contaLista) {
                if (conta.getNumero().equals(numero)){
                 return conta;
                }
            }
        }
        return null;
    }

}
