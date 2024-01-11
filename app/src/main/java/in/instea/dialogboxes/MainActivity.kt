package `in`.instea.dialogboxes

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import `in`.instea.dialogboxes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        binding.alertBtn.setOnClickListener {
            val alertBuilder = AlertDialog.Builder(this)
            alertBuilder.setTitle("Exiting...")
            alertBuilder.setIcon(R.drawable.baseline_exit_to_app_24)
            alertBuilder.setMessage("Are you sure you want to?")
            alertBuilder.setPositiveButton(
                "Yes",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    // code for action to be performed on clicking positive button
                    finish()        //close the app
                })
            alertBuilder.setNegativeButton(
                "No",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    // code for action to be performed on clicking negative button
                    Toast.makeText(this, "okay not closing...", Toast.LENGTH_SHORT).show()
                })
            alertBuilder.show()

        }

        binding.radioDialogBtn.setOnClickListener {
            val programList =
                arrayOf("C++", "Java", "DSA", "Web Development", "Android Development")

            val alertBuilder = AlertDialog.Builder(this)

            alertBuilder.setTitle("Your Favorite Items")
            alertBuilder.setSingleChoiceItems(programList,2,DialogInterface.OnClickListener { dialogInterface, i ->

                //code to perform when any radio button is selected
                Toast.makeText(this, "${programList[i]} is selected", Toast.LENGTH_SHORT).show()
            })

            alertBuilder.setPositiveButton(
                "Accept",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    // code for action to be performed on clicking positive button
                    Toast.makeText(this, "Accepted...", Toast.LENGTH_SHORT).show()
                })
            alertBuilder.setNegativeButton(
                "Reject",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    // code for action to be performed on clicking negative button
                    Toast.makeText(this, "Rejected...", Toast.LENGTH_SHORT).show()
                })
            alertBuilder.show()


        }
    }
}