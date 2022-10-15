package br.com.brandine;

import br.com.brandine.entity.Cep;
import br.com.brandine.dao.CepDao;
import br.com.brandine.util.ViaCepWs;

public class AppProject {

    public static void main(String[] args) throws Exception {

        String baseCep ="86032" ;
        for (int j = 0; j < 1000; j++) {
            if (j < 10) {
                baseCep = "8603100" + j;
                atualizarCepApi(baseCep);
            } else if (j > 10 && j <100) {
                baseCep = "860310" + j;
                atualizarCepApi(baseCep);
            } else
                if (j > 100 && j <1000) {
                 baseCep = "86031" + j;
                atualizarCepApi(baseCep);
            }
        }
        baseCep = "";
        System.out.println("CEP's foram atualizados com sucesso com cliente.");

    }

    public static void atualizarCepApi(String cep) throws Exception {
        CepDao op = new CepDao();
        Cep cadastroWs = new Cep();
        System.out.println("Buscando dados do cep: " + cep);
        Cep dadosCadastroCep = ViaCepWs.buscaCep(cep);

        /**SALVAR CADASTRO*/
        if (dadosCadastroCep.getCep() != null) {
            cadastroWs.setCep(dadosCadastroCep.getCep());
            cadastroWs.setLogradouro(dadosCadastroCep.getLogradouro());
            cadastroWs.setComplemento(dadosCadastroCep.getComplemento());
            cadastroWs.setBairro(dadosCadastroCep.getBairro());
            cadastroWs.setLocalidade(dadosCadastroCep.getLocalidade());
            cadastroWs.setUf(dadosCadastroCep.getUf());
            cadastroWs.setIbge(dadosCadastroCep.getIbge());
            cadastroWs.setGia(dadosCadastroCep.getGia());
            cadastroWs.setDdd(dadosCadastroCep.getDdd());
            cadastroWs.setSiafi(dadosCadastroCep.getSiafi());
            op.salvar(cadastroWs);
            System.out.println(dadosCadastroCep.getCep() + " foi cadastrado com sucesso.");
        }
    }
}


