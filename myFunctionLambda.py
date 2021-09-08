from sklearn.linear_model import LinearRegression 
import numpy as np
import random
from sklearn.model_selection import train_test_split
a=random.randrange(5,1000,2)
b=random.randrange(5,1000,2)

X_test,X_train, y_train, y_test=train_test_split(a,b,test_size=0.2,random_state=42)
model1=LinearRegression() 
model1.fit(X_train,y_train)
print(model1.predict(X_test)) 
print(y_test)

