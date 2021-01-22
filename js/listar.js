function validaLogin() {
    let userTxt = localStorage.getItem("userLogged");

    if (!userTxt) {
        window.location = "/index.html";  
    }

    let comunidadeTxt = localStorage.getItem("comunidade");
    let comunidade = JSON.parse(comunidadeTxt);

    document.getElementById("comunidade").innerHTML = `${comunidade.nomeComunidade} `;

    carregar(comunidade.idComunidade);
}

function logout() {
    localStorage.removeItem("userLogged");
    localStorage.removeItem("userLogged");
    window.location = "index.html";
}

function carregar(id) {

    let comunidade = {
        idComunidade:id
    }

    let msg = {
        method: 'POST',
        body: JSON.stringify(comunidade),
        headers: {
            'Content-type': 'application/json'
        }
    }

    fetch("http://localhost:8080/modernizacao/modernizacoes", msg)
        .then(res => res.json())
        .then(res => listar(res));
}

function listar(modernizacao) {
    
    let hoje = new Date();
    let tabelaModernizacao = '<table class="table table-sm"> <tr> <th>Data</th> <th>Descrção</th> <th>Percentual</th></tr>';
    
    for (i = 0; i < modernizacao.length; i++) {
        let data = new Date(modernizacao[i].dataModernizacao);
        let dataFormatada = data.toLocaleDateString("pt-BR", {timeZone:'UTC'});

        tabelaModernizacao += `<tr>`

        tabelaModernizacao = tabelaModernizacao + ` 
                            <td> ${dataFormatada} </td> 
                            <td> ${modernizacao[i].descricao} </td> 
                            <td> ${modernizacao[i].percentual} %</td> 
                        </tr>`;
    }
    tabelaModernizacao += '</table>';
    document.getElementById("tabela").innerHTML = tabelaModernizacao;
}

function voltar() {
    window.location = "tela_diretor.html"
}