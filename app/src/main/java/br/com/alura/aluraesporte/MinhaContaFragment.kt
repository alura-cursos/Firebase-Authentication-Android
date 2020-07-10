package br.com.alura.aluraesporte

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.alura.aluraesporte.ui.viewmodel.MinhaContaViewModel
import kotlinx.android.synthetic.main.minha_conta.*
import org.koin.android.viewmodel.ext.android.viewModel

class MinhaContaFragment : Fragment() {

    private val viewModel: MinhaContaViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.minha_conta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        minha_conta_email.text = viewModel.email
    }

}