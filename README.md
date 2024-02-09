POST: http://localhost:8080/notes
    
    Body:
    {
    "title": "Магазин",
    "description": "хлеб, молоко, пельмени"
    }
    
    {
    "title": "Ремонт",
    "description": "Заказать шторы"
    }

GET: http://localhost:8080/notes

GET: http://localhost:8080/notes/1, http://localhost:8080/notes/3

PUT: http://localhost:8080/notes/1
    
    Body:
    {
    "title": "Магазин",
    "description": "чай"
    }


Попытка отправить неверный запрос:

PUT: http://localhost:8080/notes/3

    {
    "title": "Магазин",
    "description":
    }

DELETE: http://localhost:8080/notes/1, http://localhost:8080/notes/3
