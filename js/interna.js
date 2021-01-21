function validaLogin() {
    let userTxt = localStorage.getItem('userLogged')
    if (!userTxt) {
        window.location = 'index.html'
    }
}

function logout() {
    localStorage.removeItem('userLogged')
    window.location = 'index.html'
}

function buscarAnuncios() {
    let idUser = document.getElementById('idUser').value
    // 'fetch' - método padrão 'GET'
    fetch('http://localhost:8080/user/id/' + idUser)
        .then(res => tratarRetorno(res))
}

function tratarRetorno(dados) {
    if(dados.status == 200){
        dados.json().then(res => exibirAnuncios(res))
    } else {
        document.getElementById('dadosAduncios').innerHTML = 'Usuário não existe.'
    }
}

function exibirAnuncios(usuario) {
    // console.log(usuario)
    if (usuario.anuncios.length == 0) { // length - tamanho do array de 'anuncios'
        document.getElementById('dadosAduncios').innerHTML = 'Unsuário não possui anúncios'
    } else {
        let anuncios = usuario.anuncios
        let dados = '<table> <tr> <th>Descrição</th> <th>Valor</th> </tr>'
        for (let i = 0; i < anuncios.length; i++) {
            dados += '<tr><td>' + anuncios[i].descricao + '</td><td>' + anuncios[i].valor + '<td></tr>'
        }
        dados += '</table>'
        document.getElementById('dadosAduncios').innerHTML = dados
    }
}