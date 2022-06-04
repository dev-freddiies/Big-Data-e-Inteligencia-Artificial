# · Importamos las librerias necesarias

library(dplyr)
library(ggplot2)
library(reshape2)
library(plotrix)
install.packages("car")
library(car)
crPlots(model_1)
install.packages("gapminder")
library(gapminder)

# --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- #



# ··· ··· ··· ··· ··· ··· ··· ··· ··· ··· Abrimos el archivo.csv y lo mostramos ··· ··· ··· ··· ··· ··· ··· ··· ··· ··· #

datos <- read.csv("coches.csv",sep = ",", header = TRUE)
datos

class(datos)

# --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- #



# ··· ··· ··· ··· ··· ··· Nos creamos una variable para cada dato extraido de la columna  ··· ··· ··· ··· ··· ··· #

X <- datos$YEAR
Y <- datos$PRECIO
Z <- datos$MARCA
V <- datos$UNIDADES.VENDIDAS
K <- datos$MODELO

# --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- #



# ··· ··· ··· ··· ··· ··· ··· ··· ··· ··· Representamos mediante graficas ··· ··· ··· ··· ··· ··· ··· ··· ··· ··· #

# · Representamos el año frente al precio y lo coloreamos dependiedo de la marca

ggplot(datos, aes(X, Y)) + geom_point(aes(colour = factor(Z)))


# · Representamos la densidad de las marcas por año

ggplot(data = datos) + geom_density(aes(x=X,fill=factor(Z)),bins=10, position = "identity",alpha = 0.5)


# · Representamos por precio y año pero pintamos por el modelo de coche

ggplot(datos, aes(Y, X)) + geom_point(aes(colour = factor(K)))


# · Dibujamos con un BoxPlot los modelos de coches por unidades vendidas

ggplot(data = datos) + geom_boxplot(aes(x=factor(K), y=V))


# · Dibujamos con un BoxPlot los modelos de coches por precio

ggplot(data = datos) + geom_boxplot(aes(x=factor(K), y=Y))


# · Vemos como a lo largo de los años las marcas cambian de precio

ggplot(datos) + geom_line(aes(x=X, y=Y,colour = factor(Z))) 


# · Vemos como a lo largo de los años las marcas pierden unidades de venta

ggplot(datos) + geom_line(aes(x=X, y=V,colour = factor(Z))) 

# --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- #



# ··· ··· ··· ··· ··· ··· ··· ··· ··· ··· Convertimos a DataFrame ··· ··· ··· ··· ··· ··· ··· ··· ··· ··· #

df <- data.frame(datos)
df

# --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- #



# ··· ··· ··· ··· ···  Sacamos la media de precio y de unidades vendidas en general ··· ··· ··· ··· ··· #

mediaUnidadesPrecio <- mean(Y)
sumaUnidadesVendidas <- sum(V)

# --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- #


# ··· ··· ··· ··· ···  Representamos años por precio con una linea roja que es la media del precio ··· ··· ··· ··· ··· #

ggplot(mapping = aes(x = X, y = Y)) +
  labs(x = "AÑOS", y = "PRECIO") +
  geom_point() +
  geom_hline(mapping = aes(yintercept = mean(Y)), color = "red")

# --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- #



# ··· ··· ··· ··· ···  Representamos años por unidades vendidas con una linea verde que es la media de las unidades vendidas ··· ··· ··· ··· ··· #

ggplot(mapping = aes(x = X, y = V)) +
  labs(x = "AÑOS", y = "UNIDADES VENDIDAS") +
  geom_point() +
  geom_hline(mapping = aes(yintercept = mean(V)), color = "green")

# --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- #



# ··· ··· ··· ··· ··· ··· ··· ··· ··· ··· FILTRAMOS POR AÑOS ··· ··· ··· ··· ··· ··· ··· ··· ··· ··· #

# · Filtramos por año 2000 y lo guardamos en una variable que se llama cochesYear2000

cochesYear2000 <- datos %>% filter(YEAR == 2000)


# · Sacamos el precio de los coches en el año 2000 y trazamos una linea roja que es la media del precio en el año 2000

ggplot(mapping = aes(x = cochesYear2000$YEAR, y = cochesYear2000$PRECIO)) +
  labs(x = "AÑO 2000", y = "PRECIO") +
  geom_point(aes(colour = factor(cochesYear2000$MARCA))) +
  geom_hline(mapping = aes(yintercept = mean(cochesYear2000$PRECIO)), color = "red")


# · Dibujamos con un boxplot los modelos de los coches por el precio 

ggplot(data = cochesYear2000) + geom_boxplot(aes(x=factor(cochesYear2000$MODELO), y=cochesYear2000$PRECIO))


# · Hacemos un diagrama de sectores con las unidades vendidas de cada marca en el año 2000 

count_3 <- c(cochesYear2000$UNIDADES.VENDIDAS)
sum(count_3)

pie(count_3, labels = paste0(count_3))

legend("topleft", legend = c(cochesYear2000$MARCA),
       fill =  c("white", "lightblue", "mistyrose"))

# --- --- --- --- 

# · Filtramos por año 2001 y lo guardamos en una variable que se llama cochesYear2001

cochesYear2001 <- datos %>% filter(YEAR == 2001)

# · Sacamos el precio de los coches en el año 2001 y trazamos una linea roja que es la media del precio en el año 2001

ggplot(mapping = aes(x = cochesYear2001$YEAR, y = cochesYear2001$PRECIO)) +
  labs(x = "Valores predichos", y = "Residuos") +
  geom_point(aes(colour = factor(cochesYear2001$MARCA))) +
  geom_hline(mapping = aes(yintercept = mean(cochesYear2001$PRECIO)), color = "red")

# · Dibujamos con un boxplot los modelos de los coches por el precio 

ggplot(data = cochesYear2001) + geom_boxplot(aes(x=factor(cochesYear2001$MODELO), y=cochesYear2001$PRECIO))

# · Hacemos un diagrama de sectores con las unidades vendidas de cada marca en el año 2000 

count_3 <- c(cochesYear2001$UNIDADES.VENDIDAS)
sum(count_3)

pie(count_3, labels = paste0(count_3))

legend("topleft", legend = c(cochesYear2000$MARCA),
       fill =  c("white", "lightblue", "mistyrose"))

# --- --- --- --- 

cochesYear2002 <- datos %>% filter(YEAR == 2002)

cochesYear2003 <- datos %>% filter(YEAR == 2003)

cochesYear2004 <- datos %>% filter(YEAR == 2004)

cochesYear2005 <- datos %>% filter(YEAR == 2005)

cochesYear2006 <- datos %>% filter(YEAR == 2006)

cochesYear2007 <- datos %>% filter(YEAR == 2007)

cochesYear2008 <- datos %>% filter(YEAR == 2008)

cochesYear2009 <- datos %>% filter(YEAR == 2009)

cochesYear2010 <- datos %>% filter(YEAR == 2010)

cochesYear2011 <- datos %>% filter(YEAR == 2011)

cochesYear2012 <- datos %>% filter(YEAR == 2012)

cochesYear2013 <- datos %>% filter(YEAR == 2013)

cochesYear2014 <- datos %>% filter(YEAR == 2014)

# --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- --- #



# · Hacemos una grafica del precio medio por años para ver como evoluciona

mediaPrecioYears <- datos %>% group_by(YEAR) %>% summarise(promPrecio=mean(PRECIO))
mediaPrecioYears

ggplot(data=mediaPrecioYears, aes(x=mediaPrecioYears$YEAR, y=mediaPrecioYears$promPrecio, group=1)) +
  geom_line(color="red")+
  geom_point()


# · Hacemos una grafica de la media de las unidades vendidas por años para ver como evoluciona

mediaUnidadesVendidasYears <- datos %>% group_by(YEAR) %>% summarise(promUnidadesVendidas=mean(UNIDADES.VENDIDAS))
mediaUnidadesVendidasYears

ggplot(data=mediaUnidadesVendidasYears, aes(x=mediaUnidadesVendidasYears$YEAR, y=mediaUnidadesVendidasYears$promUnidadesVendidas, group=1)) +
  geom_line(color="red")+
  geom_point()


# · Sacamos la tabla de la media del precio de las marcas

mediaPrecioMarcas <- datos %>% group_by(MARCA) %>% summarise(promPrecio=mean(PRECIO))
mediaPrecioMarcas


# · Realizamos la grafica del precio medio de cada marca a lo largo de los años

datos %>%
  group_by(YEAR, UNIDADES.VENDIDAS) %>%
  summarize(promPrecio=mean(PRECIO)) %>%
  ggplot(aes(x=YEAR, y=promPrecio, color= factor(Z))) + geom_line(size=2)


# · Filtramos el precio a menos de 10000 para sacar los coches de gama baja y dibujamos los puntos donde se encuentran y una linea roja que delimita el precio medio

gamaBaja <- datos %>% filter(PRECIO < 10000)

# Mostramos la tabla

datos %>% filter(PRECIO < 10000)

ggplot(mapping = aes(x = gamaBaja$YEAR, y = gamaBaja$PRECIO)) +
  labs(x = "Valores predichos", y = "Residuos") +
  geom_point(aes(colour = factor(gamaBaja$MARCA))) +
  geom_hline(mapping = aes(yintercept = mean(gamaBaja$PRECIO)), color = "red")


# · Filtramos el precio entre 10000 y 20000 para sacar los coches de gama media y dibujamos los puntos donde se encuentran y una linea roja que delimita el precio medio
  
gamaMedia <- datos %>% filter(PRECIO >= 10000, PRECIO <= 20000)

# Mostramos la tabla

datos %>% filter(PRECIO >= 10000, PRECIO <= 20000)

ggplot(mapping = aes(x = gamaMedia$YEAR, y = gamaMedia$PRECIO)) +
  labs(x = "Valores predichos", y = "Residuos") +
  geom_point(aes(colour = factor(gamaMedia$MARCA))) +
  geom_hline(mapping = aes(yintercept = mean(gamaMedia$PRECIO)), color = "red")


# · Filtramos el precio a mas de 20000 para sacar los coches de gama alta

gamaAlta <- datos %>% filter(PRECIO > 20000)

# Mostramos la tabla

datos %>% filter(PRECIO > 20000)

ggplot(mapping = aes(x = gamaAlta$YEAR, y = gamaAlta$PRECIO)) +
  labs(x = "Valores predichos", y = "Residuos") +
  geom_point(aes(colour = factor(gamaAlta$MARCA))) + 
  geom_hline(mapping = aes(yintercept = mean(gamaAlta$PRECIO)), color = "red")


maxPrecioBajo <- max(gamaBaja$PRECIO)
maxUnidadesVendidasPrecioBajo <- max(gamaBaja$UNIDADES.VENDIDAS)

maxPrecioMedio <- max(gamaMedia$PRECIO)
maxUnidadesVendidasPrecioMedio <- max(gamaMedia$UNIDADES.VENDIDAS)

maxPrecioAlto <- max(gamaAlta$PRECIO)
maxUnidadesVendidasPrecioAlto <- max(gamaAlta$UNIDADES.VENDIDAS)








  