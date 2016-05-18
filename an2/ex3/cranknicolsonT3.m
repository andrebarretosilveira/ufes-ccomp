function [x,u] = cranknicolsonT3(n,dt,npassos)
#
# Função para solução de um problema de valor inicial unidimensional
# n: número de pontos
#
# u_t - kappa * u_xx = 1

# Condições de contorno
# u(0,t) = 100
# u_x(L,t) = 0
# 
# Condições Iniciais
# u(0,0) = 100
# u(x,0) = 0
#
# Constantes Físicas
Kappa = 0.835;
L = 10;

h = L/(n-1);
x = linspace(0,L,n);

u = zeros (n,npassos);
A = zeros (n,n);
B = zeros (n,n);
b = zeros (n,1);

u(1,1) = 100;

lambda = Kappa*dt/(2*h*h);

for k = 1:npassos-1
    A(1,1) = 1;
    B(1,1) = 1;
    
	for i = 2:(n-1)
		A(i,i-1) = -lambda;
		A(i,i) = (1 + 2*lambda);
		A(i,i+1) = -lambda;
		B(i,i-1) = lambda;
		B(i,i) = (1 - 2*lambda);
		B(i,i+1) = lambda;
	end
	
	A(n,n-1) = -lambda;
	A(n,n) = (1 + lambda);
	B(n,n-1) = lambda;
	B(n,n) = (1 - lambda);

	b = B*u(:,k) + dt;
	b(1) = 100;

	u(:,k+1) = A\b;
end

plot(x,u(:,1),x,u(:,10),x,u(:,20),x,u(:,30),x,u(:,40),x,u(:,50),x,u(:,60),x,u(:,npassos));
legend('t=0.0','t=1.0','t=2.0','t=3.0','t=4.0','t=5.0','t=6.0','t=npassos*dt')
  




