package jp.co.kccs.yaml;

import java.io.File;
import java.io.FileNotFoundException;

import org.ho.yaml.Yaml;

public class MessageSettingsYamlProperty {

	/** 唯一のインスタンス */
	private static MessageSettingsYamlProperty msyp = null;

	/** YmlObject */
	private Object message_settings = null;
	/** Configファイル */
	public static final String CONFIG_FILE_NAME  = "data/mgss.yml";

	/**
	 * Singletonな為、コンストラクタは不可視です。
	 */
	private MessageSettingsYamlProperty(){
		init();
	}

	/**
	 * メッセージ設定クラスのインスタンスを取得します。
	 * @return 唯一のインスタンス
	 */
	public static MessageSettingsYamlProperty getinstance(){
		if( MessageSettingsYamlProperty.msyp == null ){
			MessageSettingsYamlProperty.msyp = new MessageSettingsYamlProperty();
		}

		return msyp;
	}

	/**
	 * YAMLファイルをロードします。
	 */
	protected void init(){
		// YAMLのload
		try {
			this.message_settings = Yaml.load(new File(CONFIG_FILE_NAME));
			System.out.println("Config YAML File loaded. FileName = [" + CONFIG_FILE_NAME + "]");
		} catch (FileNotFoundException e) {
			System.out.println("Config YAML File Not Found. All Settings will be null. FileName = [" + CONFIG_FILE_NAME + "]");
		}
	}

	/**
	 * Yaml読み込み後のオブジェクトを返します。
	 * @return message設定
	 */
	public Object getMessageSettings(){
		return message_settings;
	}

	/*
	 * テスト用メソッド
	 */
	public static void main(String[] argv){
		try {
			Object obj = Yaml.load(new File( "data/mgss.yml" ));

			System.out.println(obj);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


}
