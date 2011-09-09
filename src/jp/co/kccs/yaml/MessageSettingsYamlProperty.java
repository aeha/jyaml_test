package jp.co.kccs.yaml;

import java.io.File;
import java.io.FileNotFoundException;

import org.ho.yaml.Yaml;

public class MessageSettingsYamlProperty {

	/** �B��̃C���X�^���X */
	private static MessageSettingsYamlProperty msyp = null;

	/** YmlObject */
	private Object message_settings = null;
	/** Config�t�@�C�� */
	public static final String CONFIG_FILE_NAME  = "data/mgss.yml";

	/**
	 * Singleton�ȈׁA�R���X�g���N�^�͕s���ł��B
	 */
	private MessageSettingsYamlProperty(){
		init();
	}

	/**
	 * ���b�Z�[�W�ݒ�N���X�̃C���X�^���X���擾���܂��B
	 * @return �B��̃C���X�^���X
	 */
	public static MessageSettingsYamlProperty getinstance(){
		if( MessageSettingsYamlProperty.msyp == null ){
			MessageSettingsYamlProperty.msyp = new MessageSettingsYamlProperty();
		}

		return msyp;
	}

	/**
	 * YAML�t�@�C�������[�h���܂��B
	 */
	protected void init(){
		// YAML��load
		try {
			this.message_settings = Yaml.load(new File(CONFIG_FILE_NAME));
			System.out.println("Config YAML File loaded. FileName = [" + CONFIG_FILE_NAME + "]");
		} catch (FileNotFoundException e) {
			System.out.println("Config YAML File Not Found. All Settings will be null. FileName = [" + CONFIG_FILE_NAME + "]");
		}
	}

	/**
	 * Yaml�ǂݍ��݌�̃I�u�W�F�N�g��Ԃ��܂��B
	 * @return message�ݒ�
	 */
	public Object getMessageSettings(){
		return message_settings;
	}

	/*
	 * �e�X�g�p���\�b�h
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
