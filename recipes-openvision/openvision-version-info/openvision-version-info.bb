DESCRIPTION = "Open Vision version info"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "Open Vision Developers"
require conf/license/license-gplv2.inc

PV = "${VISIONVERSION}"
PR = "${VISIONREVISION}"

do_configure[nostamp] = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} = "${sysconfdir}"

S = "${WORKDIR}"

PACKAGES = "${PN}"

do_install() {
	install -d ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/openvision
	echo "STB=${MACHINE}" > ${D}${sysconfdir}/image-version
	echo "Brand=${BOX_BRAND}" >> ${D}${sysconfdir}/image-version
	echo "box_type=${MACHINE}" >> ${D}${sysconfdir}/image-version
	echo "build_type=0" >> ${D}${sysconfdir}/image-version
	echo "machine_brand=${BOX_BRAND}" >> ${D}${sysconfdir}/image-version
	echo "machine_name=${MACHINE}" >> ${D}${sysconfdir}/image-version
	echo "version=${VISIONVERSION}-${VISIONREVISION}" >> ${D}${sysconfdir}/image-version
	echo "visionversion=${VISIONVERSION}" >> ${D}${sysconfdir}/image-version
	echo "visionrevision=${VISIONREVISION}" >> ${D}${sysconfdir}/image-version
	echo "build=${VISIONREVISION}" >> ${D}${sysconfdir}/image-version
	if [ "${@bb.utils.contains("DISTRO_FEATURES", "python3", "1", "0", d)}" = "1" ]; then
		echo "Python=3.8" >> ${D}${sysconfdir}/image-version
	else
		echo "Python=2.7" >> ${D}${sysconfdir}/image-version
	fi
	echo "date=${DATETIME}" >> ${D}${sysconfdir}/image-version
	echo "comment=Open Vision" >> ${D}${sysconfdir}/image-version
	echo "target=9" >> ${D}${sysconfdir}/image-version
	echo "creator=Open Vision Developers" >> ${D}${sysconfdir}/image-version
	echo "url=https://openvision.tech" >> ${D}${sysconfdir}/image-version
	echo "catalog=https://github.com/OpenVisionE2" >> ${D}${sysconfdir}/image-version
	echo "distro=${DISTRO_NAME}" >> ${D}${sysconfdir}/image-version
	echo "arch=${DEFAULTTUNE}" >> ${D}${sysconfdir}/image-version
	echo "fpu=${TARGET_FPU}" >> ${D}${sysconfdir}/image-version
	echo "display-type=${DISPLAY_TYPE}" >> ${D}${sysconfdir}/image-version
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "1", "0", d)}" = "1" ]; then
		echo "small-flash=${HAVE_SMALLFLASH}" >> ${D}/etc/image-version
		echo "smallflash" > ${D}${sysconfdir}/openvision/smallflash
	fi
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "middleflash", "1", "0", d)}" = "1" ]; then
		echo "middle-flash=${HAVE_MIDDLEFLASH}" >> ${D}/etc/image-version
		echo "middleflash" > ${D}${sysconfdir}/openvision/middleflash
	fi
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "transcoding", "1", "0", d)}" = "1" ]; then
		echo "transcoding=${HAVE_TRANSCODING}" >> ${D}${sysconfdir}/image-version
	fi
	if [ "${@bb.utils.contains("MACHINE_FEATURES", "multitranscoding", "1", "0", d)}" = "1" ]; then
		echo "multitranscoding=${HAVE_MULTITRANSCODING}" >> ${D}${sysconfdir}/image-version
	fi
	echo "multilib=${HAVE_MULTILIB}" >> ${D}${sysconfdir}/image-version
	echo "${MACHINE}" > ${D}${sysconfdir}/openvision/model
	echo "${BOX_BRAND}" > ${D}${sysconfdir}/openvision/brand
	echo "${VISIONVERSION}" > ${D}${sysconfdir}/openvision/visionversion
	echo "${VISIONREVISION}" > ${D}${sysconfdir}/openvision/visionrevision
}

pkg_postinst_ontarget_${PN} () {
touch /etc/enigma2/settings
if ! grep -qs "config.plugins.CacheFlush" cat /etc/enigma2/settings ; then
	echo "config.plugins.CacheFlush.free_default=2039" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.timescrinfo=3" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.enable=true" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.timeout=5" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.uncached=0" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.where=1" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.sync=true" >>/etc/enigma2/settings
	echo "config.plugins.CacheFlush.scrinfo=false" >>/etc/enigma2/settings
fi
}

do_install[vardepsexclude] += "DATETIME"
