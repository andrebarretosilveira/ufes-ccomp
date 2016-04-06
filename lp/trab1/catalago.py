#!/usr/bin/env python
# -*- coding: utf-8 -*-

from livro import *

class Catalago:
    def __init__(self):
        self.__livros = list()

    def addLivro(self, livro):
        self.__livros = self.__livros + [livro]

    def imprimeLivros(self):
        for livro in self.__livros:
            livro.imprime()

    def lerCatalago(self, arquivo):
        f = open(arquivo, 'r')
        info = [0] * 12
        pos = 0
        line = f.readline()

        while line != '':
            # Criando um livro
            if line == '\n':
                pos = 0
                dataPub = Data(info[4][0:2], info[4][3:5], info[4][6:10])
                livro = Livro(info[0], info[1], info[2], info[3], dataPub, info[5], info[6])
                self.addLivro(livro)

            # Reunindo informações do livro
            else:
                temp = line.split('\n')
                info[pos] = temp[0]
                pos += 1

            line = f.readline()

        # Adiciona último livro
        dataPub = Data(info[4][0:2], info[4][3:5], info[4][6:10])
        livro = Livro(info[0], info[1], info[2], info[3], dataPub, info[5], info[6])
        self.addLivro(livro)

    def atualizaCatalago(self, arquivo):
        f = open(arquivo, 'r')
        line = f.readline()

        while line != '':
            # Incluir
            if line == 'i\n':
                codigo = str(f.readline().split('\n')[0])
                titulo = str(f.readline().split('\n')[0])
                autor = str(f.readline().split('\n')[0])
                assunto = str(f.readline().split('\n')[0])
                dataStr = str(f.readline().split('\n')[0])
                dataPub = Data(dataStr[0:2], dataStr[3:5], dataStr[6:10])
                editora = str(f.readline().split('\n')[0])
                resumoText = str(f.readline().split('\n')[0])
                resumo = ''
                while resumoText != '\n' and resumoText != '':
                    resumo += resumoText + ' '
                    resumoText = str(f.readline().split('\n')[0])
                livro = Livro(codigo, titulo, autor, assunto, dataPub, editora, resumo)
                self.addLivro(livro)

            # Alterar
            elif line == 'a\n':
                print "oi"

            # Excluir
            elif line == 'e\n':
                print "oi"

            line = f.readline()

    def escreverCatalago(self, arquivo):
        f = open(arquivo, 'w')
        f.write("Listagem de livros\n\n")
        for livro in self.__livros:
            dados = livro.getDados()
            for i in dados:
                f.write(i+'\n')

            f.write('\n')
