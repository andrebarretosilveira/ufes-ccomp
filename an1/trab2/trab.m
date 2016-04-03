function [] = trab(algoritmo,rlx)
filename = 'Testes/Outros/32x32.txt';
fid = fopen(filename,'r');

a = fscanf(fid,'%f',1);
b = fscanf(fid,'%f',1);
c = fscanf(fid,'%f',1);

matrixSparseeginX = fscanf(fid,'%d',1);
endX = fscanf(fid,'%d',1);
tamX = fscanf(fid,'%d',1);

matrixSparseeginY = fscanf(fid,'%d',1);
endY = fscanf(fid,'%d',1);
tamY = fscanf(fid,'%d',1);

contour = fscanf(fid,'%d',1);
t=fscanf(fid,'%d %d %f',contour*3);
func = fscanf(fid,'%s');

fclose(fid);

#------------------------ CONVERTE VETOR EM MATRIZ --------------------------------------------------
  count = 1;
  for i=1 : contour

    for j=1:3
      A(i,j) = t(count);
      count++;
    end
  end
#--------------------------------------------------------------------------------------------------

#---------------------- DISCRETIZA DOMINIO --------------------------------------------------------
hx = (endX - matrixSparseeginX)/(tamX-1);
hy = (endY - matrixSparseeginY)/(tamY-1);
qtdElementos = tamX*tamY;
lPoints = zeros(qtdElementos,2);
pos = 1;
for i=1:tamX
  for j=1:tamY
    lPoints(pos,1) = matrixSparseeginX + (j-1)*hx;
    lPoints(pos,2) = matrixSparseeginY + (i-1)*hy;
    pos++;
  end
 end
#---------------------------------------------------------------------------------------------------

#---------------------- CREATE MATRIX --------------------------------------------------------------
 matrix = zeros(qtdElementos,qtdElementos);
 aI = c + 2 *((1/(hx*hx)) + (1/(hy*hy)));
 bI = (-1/(hx*hx)) - (a/(2*hx));
 cI = (-1/(hx*hx)) + (a/(2*hx));
 dI = (-1/(hy*hy)) - (b/(2*hy));
 eI = (-1/(hy*hy)) + (b/(2*hy));

 for i=1:qtdElementos
   for j=1:qtdElementos
     if i == j
       matrix(i,j) = aI;
     elseif (j+1) == i
       matrix(i,j) = bI;
     elseif (j-1) == i
       matrix(i,j) = cI;
     elseif (j+tamX) == i #/*CONFERIR -> i - 1ou i - else if((j+input->amount) == i-1)*/
       matrix(i,j) = dI;
     elseif (j-tamY) == i # /*CONFERIR -> i-1 ou i  - else if ((j-input->amount) == i-1)*/
       matrix(i,j) = eI;
     else
       matrix(i,j) = 0;
      endif
   end
  end

#-------------------------------------------------------------------------------------------------------

#---------------------- CREATE VECTOR INDEPENDENT ------------------------------------------------------
vetIndependent = zeros(qtdElementos,1);
for i=1:qtdElementos
  x = lPoints(i,1);
  y = lPoints(i,2);
  vetIndependent(i) = eval(func);
end
#-------------------------------------------------------------------------------------------------------

#---------------------- INSERT CONTOURN ----------------------------------------------------------------


for j=1:contour
  index = A(j,1) + tamX * (A(j,2)-1);
  vetIndependent(index) = A(j,3);
  for i=1:qtdElementos
    if i == index
      matrix(index,i) = 1;
    else
      matrix(index,i) = 0;
    endif
  end
end

#-------------------------------------------------------------------------------------------------------

#---------------------- WRITE CONTOURN ----------------------------------------------------------------
nnull = length(find(matrix));
matrixSparse = zeros(nnull, 3);

cont = 1;
for i=1:qtdElementos
  for j=1:qtdElementos
    if matrix(i,j) != 0
      matrixSparse(cont,1) = i;
      matrixSparse(cont,2) = j;
      matrixSparse(cont,3) = matrix(i,j);
      cont++;
    endif
  end
end

#-------------------------------------------------------------------------------------------------------

  if strcmp("gauss",algoritmo)
    #result = matrix\vetIndependent;
    result = gauss(matrix,vetIndependent,qtdElementos);
    #save /var/www/html/upload/output.txt result
  elseif strcmp(algoritmo,"sor")
    result = sor(matrix,vetIndependent,qtdElementos,0.001,10000,rlx);
    #save /var/www/html/upload/output.txt result
  else
    printf("nome de algoritmo invalido");

  endif;
  filename = 'output.txt';
  fou = fopen(filename,"a+");
  fprintf(fou,'%f\n',result);
  fclose(fou);


end
