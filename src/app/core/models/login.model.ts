export interface TokenResponse {
  id?: number;
  token: string;
  roles: String[];
}

export interface AuthentificationRequest {
  username?: string;
  password?: string;
}
