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

function inserir() {
    let data = document.getElementById("data").value;
    let descricao = document.getElementById("descricao").value;
    let percentual = document.getElementById("porcentagem").value;

    let comunidadeTxt = localStorage.getItem("comunidade");
    let comunidade = JSON.parse(comunidadeTxt);

    let novaModernizacao = {
        dataModernizacao: data,
        descricao,
        percentual,
        comunidade :{
            idComunidade: comunidade.idComunidade
        }
    }

    let msg = {
        method: 'POST',
        body: JSON.stringify(novaModernizacao),
        headers: {
            'Content-type': 'application/json'
        }
    }

    fetch("http://localhost:8080/modernizacao/new", msg)
        .then(res => tratarResultado(res));
}

function tratarResultado(res) {
    if (res.status == 200) {
        alert('Cadastro realizado com sucesso!');
        window.location = "tela_diretor.html";
    } else {
                alert('Erro no cadastro...');
            }
}