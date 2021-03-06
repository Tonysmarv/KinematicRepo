l0= 28;
l1 = 50; 
l2= 60;

theta0 = -pi:pi:pi;
theta1 = 0:0.1:pi/2;
theta2 = -pi/2:0.1:0.1; 

[THETA0,THETA1,THETA2] = meshgrid(theta0,theta1,theta2); 

X =((l2 .* cos(THETA1+THETA2))).*cos(THETA0)  + (l1 .* cos(THETA1)).*cos(THETA0); 

Z = l2 .* sin(THETA1 + THETA2) + l1 .* sin(THETA1) + l0 ;

plot(X(:),Z(:),'b.');
  axis equal;
  xlabel('X','fontsize',10)
  ylabel('Y','fontsize',10)
  zlabel('Z','fontsize',10)
  title('X-Y-Z Coordenadas usando teta1, teta2, teta3 como valores de entrada','fontsize',10)
  
