import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Startup Name Generator',
      theme: ThemeData(
        primarySwatch: Colors.indigo,
      ),
      home: Registers(),
    );
  }
}


class Registers extends StatefulWidget {
  @override
  _RegistersState createState() => _RegistersState();
}

class _RegistersState extends State<Registers> {
  List<String> _registerItems = [];

  // Função será chamada quando o botão "+" for pressionado
  void _addTodoRegister(String reg) {
    // O método setState() indica que o estado da widget foi alterado.
    if(reg.length > 0) {
      setState(() => _registerItems.add(reg));
    }
  }

  void _removeTodoRegister(int index) {
    setState(() {
      _registerItems.removeAt(index);
    });
  }

  void _promptRemoveTodoRegister(int index) {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return new AlertDialog(
          title: new Text('Marcar "${_registerItems[index]}" como concluída?'),
          actions: <Widget>[
            new FlatButton(
              child: new Text('Cancelar'),
              onPressed: () => Navigator.of(context).pop() // Fecha a tela
            ),
            new FlatButton(
              child: new Text('Marcar como concluída'),
              onPressed: () {
                _removeTodoRegister(index);
                Navigator.of(context).pop(); // Fecha a tela
              },
            )
          ]
        );
      }
    );
  }

  // Construção da lista de registros
  Widget _buildRegisterList() {
    return new ListView.builder(
      // ignore: missing_return
      itemBuilder: (context, index) {
        // A função itemBuilder é chamada até preencher o ListView.
        if(index < _registerItems.length) {
          return _buildRegisterItem(_registerItems[index], index);
        }
      },
    );
  }

  // Construção de um registro novo
  Widget _buildRegisterItem(String registerText, int index) {
    return new ListTile(
      title: new Text(registerText),
      onTap: () => _promptRemoveTodoRegister(index),
    );
  }

  void _pushAddRegisterScreen() {
    // Coloca a nova tela na stack
    Navigator.of(context).push(
        new MaterialPageRoute(
            builder: (context) {
              return new Scaffold(
                  appBar: new AppBar(
                      title: new Text('Addicione um novo registro')
                  ),
                  body: new TextField(
                    autofocus: true,
                    onSubmitted: (val) {
                      _addTodoRegister(val);
                      Navigator.pop(context); // Fecha a tela atual
                    },
                    decoration: new InputDecoration(
                        hintText: 'Digite uma tarefa a fazer...',
                        contentPadding: const EdgeInsets.all(16.0)
                    ),
                  )
              );
            }
        )
    );
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('To-do')
      ),
      body: _buildRegisterList(),
      floatingActionButton: new FloatingActionButton(
        onPressed: _pushAddRegisterScreen, // Apertar o botão chama a tela de registro
        tooltip: 'Adicionar tarefa',
        child: new Icon(Icons.add),
      ),
    );
  }

}
