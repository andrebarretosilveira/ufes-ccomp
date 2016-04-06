#!/usr/bin/env python
# -*- coding: utf-8 -*-

from livro import *

class Catalago:
    def __init__(self):
        self.__livros = list()

    def addLivro(self, livro):
        self.__livros.append(livro)

    def removeLivro(self, codigo):
        pos = 0
        for livro in self.__livros:
            if livro.getCodigo() == codigo:
                self.__livros.pop(pos)
                break
            pos += 1

    def imprimeLivros(self):
        for livro in self.__livros:
            livro.imprime()

    def lerCatalago(self, arquivo):
        f = open(arquivo, 'r')
        info = [0] * 12
        pos = 0
        resumoPart = ' '

        while resumoPart != '':
            codigo = str(f.readline().split('\n')[0])
            titulo = str(f.readline().split('\n')[0])
            autor = str(f.readline().split('\n')[0])
            assunto = str(f.readline().split('\n')[0])
            dataStr = str(f.readline().split('\n')[0])
            dataPub = Data(dataStr[0:2], dataStr[3:5], dataStr[6:10])
            editora = str(f.readline().split('\n')[0])
            resumoPart = str(f.readline())
            resumo = ''
            while resumoPart != '\n' and resumoPart != '':
                resumo += resumoPart
                resumoPart = str(f.readline())

            livro = Livro(codigo, titulo, autor, assunto, dataPub, editora, resumo)
            self.addLivro(livro)

    def atualizarCatalago(self, arquivo):
        f = open(arquivo, 'r')
        line = f.readline()

        while line != '':
            # Leitura de dados em caso de inserção ou alteração
            if line == 'i\n' or line == 'a\n':
                codigo = str(f.readline().split('\n')[0])
                titulo = str(f.readline().split('\n')[0])
                autor = str(f.readline().split('\n')[0])
                assunto = str(f.readline().split('\n')[0])
                dataStr = str(f.readline().split('\n')[0])
                dataPub = Data(dataStr[0:2], dataStr[3:5], dataStr[6:10])
                editora = str(f.readline().split('\n')[0])
                resumoPart = str(f.readline())
                resumo = ''
                while resumoPart != '\n' and resumoPart != '':
                    resumo += resumoPart
                    resumoPart = str(f.readline())

                # Caso de inserção
                if line == 'i\n':
                    livro = Livro(codigo, titulo, autor, assunto, dataPub, editora, resumo)
                    self.addLivro(livro)

                # Caso de alteração
                else:
                    for livro in self.__livros:
                        if livro.getCodigo() == codigo:
                            livro.alteraDados(codigo, titulo, autor, assunto, dataPub, editora, resumo)
                            break

            # Caso de exclusão
            elif line == 'e\n':
                codigo = str(f.readline().split('\n')[0])
                self.removeLivro(codigo)

            line = f.readline()

    def escreverSaida(self, arquivo):
        f = open(arquivo, 'w')
        f.write("Listagem de livros\n\n")
        for livro in self.__livros:
            dados = livro.getDados()
            for i in dados:
                f.write(i+'\n')

    def escreverCatalago(self, arquivo):
        f = open(arquivo, 'w')
        for livro in self.__livros:
            dados = livro.getDados()
            for i in dados:
                f.write(i+'\n')
