package com.olympia.main.view

import android.content.Intent
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.olympia.main.model.verification.check_password.ICheckPassword
import com.olympia.main.view.for_recycler_view.RVItem

fun Fragment.openFragment(holderId: Int, f: Fragment) {
    (activity as AppCompatActivity).supportFragmentManager.beginTransaction().replace(holderId, f).commit()
}
fun Fragment.message(text: String) = Toast.makeText((activity as AppCompatActivity), text, Toast.LENGTH_SHORT).show()
fun Fragment.description(item: RVItem) {
    startActivity(Intent((activity as AppCompatActivity), ContentActivity::class.java).apply { putExtra("Cat", item) })
}
fun Fragment.randItemFromArray(arrayId: Int): Int{
    val arraySize = resources.getStringArray(arrayId).size - 1
    return (0..arraySize).random()
}
fun Fragment.getItemFromArray(arrayId: Int): String{ return resources.getStringArray(arrayId)[randItemFromArray(arrayId)] }
object Info {
    var userName = ""
    var password = ""
    const val homeDescription2 = "Как быстро можно потерять мышечную массу без тренировок\n" +
            "•   Регулярные тренировки важны для роста физической силы и выносливости.\n" +
            "•   Перерыв в тренировках может привести к потере мышечной массы, но это зависит от времени и вида тренировок.\n" +
            "•   Скорость потери мышечной массы зависит от уровня физической подготовки, кардио тренировок и возраста.\n" +
            "•   Пожилые люди теряют мышечную массу быстрее, чем молодые, но не имеют различий между мужчинами и женщинами.\n" +
            "•   \"Мышечная память\" помогает профессиональным спортсменам и любителям быстрее вернуться к прежней форме после перерыва.\n" +
            "•   Трехнедельный перерыв в силовом фитнесе обычно не влияет на результаты, но уменьшение нагрузок может повлиять на выносливость.\n" +
            "•   Сохранение минимальной нагрузки во время перерыва может замедлить потерю прогресса.\n" +
            "•   Комфортный режим тренировок поможет поддерживать форму в долгосрочной перспективе."
    const val homeDescription0 = "Продукты, богатые белком, для наращивания мышц\n" +
            "•   Наращивание мышечной массы требует силы и сбалансированного белкового питания.\n" +
            "•   Продукты, богатые белком, такие как яйца, лосось, грудка птицы, молочные продукты, тунец, креветки, морские гребешки, соевые бобы, говядина, творог, фасоль, нут, арахис, миндаль, гречка, тофу, коричневый рис, протеиновые порошки.\n" +
            "•   Для роста мышц нужно употреблять продукты с высоким содержанием белка, такие как курица, лосось, греческий йогурт, бобы, творог, яйца.\n" +
            "•   Для анаболического роста необходимо употреблять больше калорий, чем вы сжигаете.\n" +
            "•   Помочь достигнуть эффективного баланса может фитнес-тренер или нутрициолог."
    const val homeDescription1 = "Сколько мышечной массы должно быть у мужчин и у женщин\n" +
            "•   Мышечная масса важна для здоровья и физической функции.\n" +
            "•   Она влияет на риск травм, хронических заболеваний и ранней смерти.\n" +
            "•   Мышечная масса влияет на силу, подвижность и равновесие.\n" +
            "•   Трудно точно измерить мышечную массу, но можно использовать процентное содержание жира в организме.\n" +
            "•   Для роста мышц подходят силовые тренировки, аэробные упражнения и правильное питание.\n" +
            "•   Важно потреблять достаточное количество белка, углеводов и жиров для набора и сохранения мышечной массы.\n" +
            "•   Мышечная масса является частью безжировой массы тела и влияет на физическую форму.\n" +
            "•   Точный расчет мышечной массы сложен, но можно использовать МРТ для оценки."
}
fun setData(userName: String, password: String){
    Info.userName = userName
    Info.password = password
}