<!-- Modal Registrazione -->
<div class="modal fade" id="myRegistrazione" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<form method="post" action="RegistrazioneServlet">
					<div class="form-group">
						<input class="form-control" type="text" name="nome" placeholder="Nome" />
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="cognome" placeholder="Cognome" />
					</div>
					<div class="form-group">
						<input class="form-control" type="email" name="email" placeholder="Email" />
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="citta" placeholder="Città" />
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="provincia" placeholder="Provincia" />
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="via" placeholder="Via" />
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="numero" placeholder="Numero" />
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="cap" placeholder="CAP" />
					</div>
					<div class="form-group">
						<input class="form-control" type="text" name="username" placeholder="Username" />
					</div>
					<div class="form-group">
						<input class="form-control" type="password" name="password" placeholder="Password" />
					</div>
					<div class="form-group">
						<div class="form-check">
							<label class="form-check-label"><input class="form-check-input" type="checkbox" />I agree to the license terms.</label>
						</div>
					</div>
					<div class="form-group">
						<button class="btn btn-primary btn-block" type="submit">Registrazione</button>
					</div>
					<a class="already" href="#" data-toggle="modal" data-target="#myLogin">Hai già un account? Login qui.</a>
				</form>
			</div>
		</div>
	</div>
</div>