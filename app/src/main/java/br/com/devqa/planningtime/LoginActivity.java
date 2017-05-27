package br.com.devqa.planningtime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.devqa.planningtime.dao.UsuarioDAO;
import br.com.devqa.planningtime.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    private String nome;
    private String senha;

    private UsuarioDAO usuarioDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void autenticar(View view) {
        if (verificarPreenchimentoDosCampos()) {
            Usuario usuario = obterDadosUsuario(true);
            if (usuario == null) {
                Toast.makeText(this, "Usuário e/ou senha incorretos!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Bem vindo(a) " + usuario.getNome() + "!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void cadastrar(View view) {
        if (verificarPreenchimentoDosCampos()) {
            Usuario usuario = obterDadosUsuario(false);
            usuarioDAO.inserirUsuario(usuario);
            startActivity(new Intent(this, FormularioAtividadeActivity.class));
        }
    }

    private Usuario obterDadosUsuario(boolean autentica) {
        Usuario usuario = null;
        if (autentica) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(this);
            usuario = usuarioDAO.pesquisarPeloNomeSenha(nome, senha);
        } else {
            usuario = new Usuario(nome, senha);
        }
        return usuario;
    }

    private boolean verificarPreenchimentoDosCampos() {
        nome = ((EditText) findViewById(R.id.edtUsuarioLogin)).getText().toString();
        senha = ((EditText) findViewById(R.id.edtSenhaLogin)).getText().toString();

        if (nome.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, "O nome e a senha são obrigatórios!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
