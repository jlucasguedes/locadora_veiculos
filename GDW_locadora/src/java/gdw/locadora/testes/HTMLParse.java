/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gdw.locadora.testes;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author lucas
 */
public class HTMLParse {
    public static void main(String[] args) {
        Document doc;
        
        try {
            doc = Jsoup.connect("http://semed.palmas.to.gov.br/sge/indexrelatorio.php?url=CE83A426EE754E1B8772E50528BCA8D6&idpessoa=93518&idunidade=15&datalotacao=2013-10-02&idlotacao=7766").get();
            
            //pega o titulo da pagina
            String title = doc.title();
            System.out.println("Title: " + title);
            
            //pega todos os links da página
            Elements links = doc.select("div div div:nth-child(1) tr:nth-child(3) td:nth-child(2)");
            FichaFuncional ff = new FichaFuncional();
            ff.setCpf(doc.select("div div div:nth-child(1) tr:nth-child(1) td:nth-child(2)").text());
            ff.setNome(doc.select("div div div:nth-child(1) tr:nth-child(2) td:nth-child(2)").text());
            ff.setSexo(doc.select("div div div:nth-child(1) tr:nth-child(3) td:nth-child(2)").text());
            ff.setDataNascimento(doc.select("div div div:nth-child(1) tr:nth-child(4) td:nth-child(2)").text());
            ff.setDatadeCadastro(doc.select("div div div:nth-child(1) tr:nth-child(5) td:nth-child(2)").text());
            ff.setEndereco(doc.select("div div div:nth-child(1) tr:nth-child(6) td:nth-child(2)").text());
            ff.setComplemento(doc.select("div div div:nth-child(1) tr:nth-child(7) td:nth-child(2)").text());
            ff.setCep(doc.select("div div div:nth-child(1) tr:nth-child(8) td:nth-child(2)").text());
            ff.setBairro(doc.select("div div div:nth-child(1) tr:nth-child(9) td:nth-child(2)").text());
            ff.setCidadeDeResidência(doc.select("div div div:nth-child(1) tr:nth-child(10) td:nth-child(2)").text());
            ff.setTelefonResidencial(doc.select("div div div:nth-child(1) tr:nth-child(11) td:nth-child(2)").text());
            ff.setTelefone(doc.select("div div div:nth-child(1) tr:nth-child(12) td:nth-child(2)").text());
            ff.setCelular(doc.select("div div div:nth-child(1) tr:nth-child(13) td:nth-child(2)").text());
            ff.setEmail(doc.select("div div div:nth-child(1) tr:nth-child(14) td:nth-child(2)").text());
            ff.setNomeDoPai(doc.select("div div div:nth-child(1) tr:nth-child(15) td:nth-child(2)").text());
            ff.setNomedaMae(doc.select("div div div:nth-child(1) tr:nth-child(16) td:nth-child(2)").text());
            ff.setCodINEP(doc.select("div div div:nth-child(1) tr:nth-child(17) td:nth-child(2)").text());
            ff.setMatricula(doc.select("div div div:nth-child(1) tr:nth-child(18) td:nth-child(2)").text());

            
            System.out.println("CPF: " + ff.getCpf());
            System.out.println("Nome: " + ff.getNome());
            System.out.println("Sexo: " + ff.getSexo());
            System.out.println("Data de Nascimento: " + ff.getDataNascimento());
            System.out.println("Data de Cadastro: " + ff.getDatadeCadastro());
            System.out.println("Endereço: " + ff.getEndereco());
            System.out.println("Complemento: " + ff.getComplemento());
            System.out.println("CEP: " + ff.getCep());
            System.out.println("Bairro: " + ff.getBairro());
            System.out.println("Cidade de residência: " + ff.getCidadeDeResidência());
            System.out.println("Telefone residência: " + ff.getTelefonResidencial());
            System.out.println("Telefone: " + ff.getTelefone());
            System.out.println("Celular: " + ff.getCelular());
            System.out.println("E-mail: " + ff.getEmail());
            System.out.println("Nome do pai: " + ff.getNomeDoPai());
            System.out.println("Nome da mãe: " + ff.getNomedaMae());
            System.out.println("Código INEP: " + ff.getCodINEP());
            System.out.println("Matrícula: " + ff.getMatricula());
//            System.out.println(ff.getCpf());
//            for (Element link : links) {
//
//                System.out.println(link.text());
//                    
//            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
