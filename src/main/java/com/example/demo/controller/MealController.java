package com.example.demo.controller;


import com.example.demo.entity.Meal;
import com.example.demo.service.MealService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/meal")
public class MealController {

    /* @Autowired è un annotazione utilizzatgas in ambito Spring
    Framework per la gestione dell'inizione delle dipendenze.

    @Autowired viene utilizzato per iniettare le dipendenze in un oggetto senza
    crearle manualmente.

    Quando si applica @Autowired a un campo, un costruttore o un metodo setter all'interno
    di una classe gestita da Spring, Spring cercherà una corrispondenza per quella dipendenza e
     la inietterà automaticamente durante la creazione dell'oggetto. Questo processo si basa sulla
     riflessione e sulla scansione del contesto dell'applicazione Spring per individuare le corrispondenti
      implementazioni delle interfacce o classi necessarie.



      import org.springframework.beans.factory.annotation.Autowired;

public class MyClass {
    private MyDependency myDependency;

    @Autowired
    public MyClass(MyDependency myDependency) {
        this.myDependency = myDependency;
    }

    // ...
}

In questo caso, @Autowired è applicato al costruttore di MyClass, e Spring si prenderà cura
 di iniettare automaticamente un'istanza di MyDependency quando un oggetto MyClass viene creato.

L'utilizzo di @Autowired semplifica notevolmente la gestione delle dipendenze all'interno di un'applicazione
Spring, in quanto elimina la necessità di istanziare manualmente oggetti dipendenti e le relative configurazioni.
 Ciò rende l'applicazione più modulare e più facile da testare, manutenere e scalare.


     */
    @Autowired
    private MealService mealService;

    @GetMapping("/selectAll")
    public ResponseEntity<List<Meal>> selectAllMeals(){
        return ResponseEntity.ok(mealService.selectAll());
    }

    @GetMapping("/selectByName/{name}")
    public ResponseEntity<Meal> selectByName(@PathVariable("name") String nomeDaCercare) {
        Optional<Meal> opt = mealService.findByName(nomeDaCercare);
        if (opt.isPresent()) {
            return ResponseEntity.ok(opt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/selectByDescription/{description}")
    public ResponseEntity<Meal> selectByDescription (@PathVariable("description") String descriptionDaCercare){
        Optional<Meal> opt = mealService.findByDescription(descriptionDaCercare);
        if (opt.isPresent()) {
            return ResponseEntity.ok(opt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/selectByPriceRange/{min}/{max}")
    public ResponseEntity<Meal> selectByPriceRange(@PathVariable("min") Double min, @PathVariable("max") Double max){
    Optional<Meal> opt = mealService.findByPriceRange(min, max);
    if (opt.isPresent()){
        return ResponseEntity.ok(opt.get());
    }else{
        return ResponseEntity.notFound().build();
    }
    }



    @PostMapping("/insert")
    public ResponseEntity<Meal> insertProdotto(@RequestBody Meal prodotto){
        if(mealService.addMeal(prodotto)) {
            return ResponseEntity.ok(prodotto);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }





    }














