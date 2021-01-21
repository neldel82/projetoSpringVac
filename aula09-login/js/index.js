function hello() {
    alert('Hello World!');
}

// let texto = usuario.value;
//console.log(texto);
// document.getElementById("output").innerHTML = texto;

/*

Uma arrow function é equivalente a uma função "tradicional" do Javascript

(params) => console.log();

function name(params) {
    console.log();
}

*/


function login() {
    let usuario = document.getElementById("user").value;
    let senha = document.getElementById("password").value;

    // construindo um objeto javascript para enviar
    let loginMsg = {
        email: usuario,
        cpf: usuario,
        password: senha
    }

    // construindo ua mensagem que será enviada ao backend
    let msg = {
        method: 'POST',
        body: JSON.stringify(loginMsg),
        headers: {
            'Content-type': 'application/json'
        }
    }

    // fetch envia para o servidor 'localhost' o objeto 'msg'
    // '.then' - quando voltar a resposta
    // '=>' arrow function que chama a próxima função com o parâmetro 'res'
    // 'res' é o retorno do fetch
    fetch("http://localhost:8080/user/login", msg)
        .then(res => tratarRetorno(res));

}

function tratarRetorno(retorno) {
    if (retorno.status == 200) {
        document.getElementById("output").innerHTML = "login com sucesso";
        // extrai o objeto json de dentro do 'retorno' e passa para a função 'acessoPermitido'
        retorno.json().then(res => acessoPermitido(res));
    } else {
        document.getElementById("output").innerHTML = "usuário/senha inválidos"
    }
}

function acessoPermitido(user) {
    //console.log(user);
    localStorage.setItem("userLogged", JSON.stringify(user));
    window.location = "interna.html";
}