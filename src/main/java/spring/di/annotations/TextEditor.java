package spring.di.annotations;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
   // 使用注解的配置方式无需setter方法
   @Autowired
   private SpellChecker spellChecker;

   public SpellChecker getSpellChecker() {
      return spellChecker;
   }
   public void spellCheck() {
      spellChecker.checkSpelling();
   }
}