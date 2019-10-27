SMALLFL = "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "gstplayer", "exteplayer3 gstplayer", d)}"
RRECOMMENDS_${PN} = "${@bb.utils.contains("MACHINE_FEATURES", "exteplayeronly", "exteplayer3", "${SMALLFL}", d)}"

pkg_postinst_${PN}_exteplayeronly() {
	touch $D${sysconfdir}/enigma2/serviceapp_replaceservicemp3
	if [ -e $D${sysconfdir}/enigma2/settings ]
	then
		sed -i '/config.plugins.serviceapp.servicemp3.player=/d' $D${sysconfdir}/enigma2/settings
		sed -i '/config.plugins.serviceapp.servicemp3.replace=/d' $D${sysconfdir}/enigma2/settings
		echo "config.plugins.serviceapp.servicemp3.player=exteplayer3" >> $D${sysconfdir}/enigma2/settings
		echo "config.plugins.serviceapp.servicemp3.replace=true" >> $D${sysconfdir}/enigma2/settings
	else
		echo "config.plugins.serviceapp.servicemp3.player=exteplayer3" > $D${sysconfdir}/enigma2/settings
		echo "config.plugins.serviceapp.servicemp3.replace=true" >> $D${sysconfdir}/enigma2/settings
	fi
}

CXXFLAGS_append_cube += " -std=c++11 -fPIC -fno-strict-aliasing "
CXXFLAGS_append_su980 += " -std=c++11 -fPIC -fno-strict-aliasing "
CXXFLAGS_append_sh4 += " -std=c++11 -fPIC -fno-strict-aliasing "

pkg_postinst_${PN}_sh4() {
	touch $D${sysconfdir}/enigma2/serviceapp_replaceservicemp3
	if [ -e $D${sysconfdir}/enigma2/settings ]
	then
		sed -i '/config.plugins.serviceapp.servicemp3.player=/d' $D${sysconfdir}/enigma2/settings
		sed -i '/config.plugins.serviceapp.servicemp3.replace=/d' $D${sysconfdir}/enigma2/settings
		echo "config.plugins.serviceapp.servicemp3.player=exteplayer3" >> $D${sysconfdir}/enigma2/settings
		echo "config.plugins.serviceapp.servicemp3.replace=true" >> $D${sysconfdir}/enigma2/settings
	else
		echo "config.plugins.serviceapp.servicemp3.player=exteplayer3" > $D${sysconfdir}/enigma2/settings
		echo "config.plugins.serviceapp.servicemp3.replace=true" >> $D${sysconfdir}/enigma2/settings
	fi
}
