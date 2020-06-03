# This recipe serves as an example of how you can arrange
# for extra components to be preinstalled while remaining
# compatible with the central repository.

require ../../../meta-openvision/recipes-openvision/images/openvision-enigma2-image.bb

IMAGE_INSTALL += "enigma2-plugin-softcams-ncam \
	enigma2-plugin-softcams-oscam \
	enigma2-plugin-softcams-oscam-emu \
	"
