set nocompatible
filetype off

set rtp+=~/.vim/bundle/Vundle.vim
call vundle#begin()

" let Vundle manage Vundle, required
Plugin 'gmarik/Vundle.vim'

" bundles
Plugin 'nvie/vim-flake8'
Plugin 'git://github.com/scrooloose/syntastic.git'
Plugin 'git://github.com/scrooloose/nerdtree.git'

call vundle#end()
filetype plugin indent on

" copiar texto do vim para outros arquivos.
set viminfo='10,\"30,:20,%,n~/.viminfo

" manter o cursor na posição antes do fechamento do vim.
au BufReadPost * if line("'\"")|execute("normal `\"")|endif

" ativar sintaxes gay-coloridas
syntax enable

" habilitar plugins:
filetype plugin on

" good stuff
set number
set autoindent
set smartindent
set expandtab
set softtabstop=4
set shiftwidth=4
set tabstop=4
set background=dark

" set colors
set t_Co=256

" jump to end of parenthesis/bracket
inoremap <C-j> <Esc>/[)}"'\]>]<CR>:nohl<CR>a

" late bracketing
vnoremap _( <Esc>`>a)<Esc>`<i(<Esc>

" folding options
set fdm=indent
nnoremap <C-o> za

" folding colors
hi Folded term=standout ctermfg=12 ctermbg=none

" open NerdTree
map <C-e> :NERDTreeToggle<CR>

" set enconding
set encoding=utf-8

" Syntastic settings
set statusline+=%#warningmsg#
set statusline+=%{SyntasticStatuslineFlag()}
set statusline+=%*
let g:syntastic_always_populate_loc_list = 1
let g:syntastic_auto_loc_list = 1
let g:syntastic_check_on_open = 1
let g:syntastic_check_on_wq = 0
let python_highlight_all=1

syntax on
