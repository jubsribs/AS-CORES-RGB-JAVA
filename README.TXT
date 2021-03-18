
TITULO DO PROJETO: Avaliação 2021.1

OBJETIVO DO PROJETO:As cores RGB modelam um sistema de cores aditivas em que o Vermelho (Red), o Verde (Green) e o Azul (Blue) são combinados de várias formas de modo a reproduzir um largo espectro cromático. Uma cor RGB é representada por uma 3-upla, onde cada elemento pode assumir um valor de 0 a 255, representando a quantidade de vermelho, verde e azul que compõem a cor. Em cores RGB, a luminosidade é calculada através da expressão de luminosidade = (R*0.3 + G*0.59 + B *0.11) / 255, que deve ser truncada para um valor inteiro.

Escreva
i. uma classe que represente uma cor RGB

ii. a representação estática da classe criada

iii. os métodos que lêem e alteram os valores das componentes RGB da cor

iv. um método que leia a luminosidade da cor

v. construtores sobrecarregados que permitam a criação de uma cor
  i. um construtor de cópia, que crie uma cor idêntica (mesmo valor de R, G e B)
  ii. um construtor sem parâmetros, que crie a cor preta (&lt;R=0, G=0, B=0&gt;)
  iii. um construtor que receba três valores como parâmetros e crie uma considerando estes valores como os valores de R, G e B, respectivamente

vi. um método que verifique se duas cores são iguais. As cores são consideradas iguais se seus valores de R, G e B são idênticos entre si (o R de uma cor igual o R da outra e assim por diante)

vii. altere as propriedades Red, Green e Blue e Luminosidade para serem exclusivamente leitura

viii. um método que gere uma representação String da cor como hexadecimal. A representação é composta pelo caracter # seguida de dois dígitos representando o valor de R, G e B em hexadecimal. Por exemplo, para a cor RGB, onde R=37, G=150, B=190, o método deve retornar: #2596BE

INF008 – Graduação Tecnológica em Análise e Desenvolvimento de Sistemas – Avaliação – 2021.1

ix. um método clarear que receba um valor e modifique a tonalidade da cor em questão a tornando mais clara. Para isso, o método deve modificar os valores RGB, para um novo valor p percentual menor, onde p deve ser indicado como parâmetro. Por exemplo, para a cor #2596BE, se o parâmetro de clarear for 0.1 (10%), a cor deve se tornar #2187ab.

x. um método escurecer que receba um valor e modifique a tonalidade da cor em questão a tornando mais escura. Para isso, o método deve modificar os valores RGB, para um novo valor p percentual maior, onde p deve ser indicado como parâmetro. Por exemplo, para a cor #2596BE, se o parâmetro de escurecer for 0.1 (10%), a cor deve se tornar #2187AB.

xi. Um método que retorne uma nova instância de CorRGB, igual a cor que recebeu a mensagem

VERSÃO ou DATA:18/03/2021 
AUTORES:Isaac Santos,Joao Pedro,Juliana Ribeiro
